package ice.jdbc

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

import scala.util.Either
import scala.util.matching.Regex

trait IExtraWorker {
  // (target, name, args) => Either[exception, args]
  type ProcessArgumentsFunction = (AnyRef, String, Any) => Either[Throwable, Any]
  // (target, name, args, Either[exception, returnValue], time) => Either[exception, returnValue]
  type ProcessResultFunction = (AnyRef, String, Any, Either[Throwable, Any], Long) => Either[Throwable, Any]

  def processArguments: ProcessArgumentsFunction

  def processResult: ProcessResultFunction
}

object NopWorker extends IExtraWorker {
  override val processArguments: ProcessArgumentsFunction = (_, _, args) => Right(args)
  override val processResult: ProcessResultFunction = (_, _, _, result, _) => result
}

object StandardLogWorker extends StandardLogWorker

class StandardLogWorker extends IExtraWorker {

  override val processArguments: ProcessArgumentsFunction = NopWorker.processArguments
  override def processResult: ProcessResultFunction = STANDARD_LOG_PROCESS_RESULT

  private val skipClassNameRegex: Regex = """^(java\.|scala\.|ice\.jdbc\.).*""".r

  protected def isSkipClassName(s: String): Boolean = skipClassNameRegex.matches(s)

  protected def from: String = {
    val stackTrace = new Exception().getStackTrace

    "from: " +
      stackTrace.find {
        st => !isSkipClassName(st.getClassName)
      }.map {
        st => s"${st.getClassName}.${st.getMethodName}(${st.getFileName}:${st.getLineNumber})"
      }.getOrElse("")
  }

  protected def formatAndReplaceCRLF(a: Any): String = Option(a).map(_.toString.replaceAll("[\r\n]", "\t")).orNull

  protected def formatResult(either: Either[Throwable, Any]): String = {
    either match {
      case Right(()) => s"returned"
      case Right(ret) => s"returned: ${formatAndReplaceCRLF(ret)}"
      case Left(th) => s"thrown: ${formatAndReplaceCRLF(th)}"
    }
  }

  protected def formatTime(time: Long): String = s"time: ${time / 1000}.${"%03d".format(time % 1000)}"

  protected def currentTime: String =
    new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.UK).format(new Timestamp(System.currentTimeMillis()))

  protected def makeMessageString(target: AnyRef, name: String, args: Any, result: Either[Throwable, Any], time: Long): String =
    s"$currentTime ${formatAndReplaceCRLF(target)}.$name${formatAndReplaceCRLF(args)} ${formatResult(result)} ${formatTime(time)} $from"

  protected def makeBindInfoString(ps: IPreparedStatement): String = {
    val noBinds = ps.isUsedBindValuesEmpty
    val bindValues = s" binds: {${ps.usedBindValueStrings.mkString("\t")}}"
    val bindClassNames = s" bindClasses: {${ps.usedBindValueClassNames.mkString("\t")}}"
    val sqlString = s" sql: {${if (noBinds) ps.sql else ps.makeUsedBindValueEmbeddedSql}}"
    formatAndReplaceCRLF(s"$bindValues$bindClassNames$sqlString")
  }

  protected def mask(s: Any): String = s.toString.replaceAll("(pass|pa?s?s?wo?r?d)=.*?([},])", "$1=*$2")

  @throws(classOf[java.io.IOException])
  protected def write(s: String): Unit = println(s)

  protected val STANDARD_LOG_PROCESS_RESULT: ProcessResultFunction = (target, name, args, result, time) => {
    def messageString: String = makeMessageString(target, name, args, result, time)

    (target, name, args, result) match {
      case (_: IDriver, "connect", _, Right(null)) =>
      // 受け入れ可能なURLでない場合のnull返却は出力対象外
      case (_: IDriver, "connect", (url, info), _) =>
        write(s"${makeMessageString(target, name, (url, mask(info)), result, time)}")
      case (_: IConnection, "prepareStatement" | "prepareCall" | "commit" | "rollback" | "close", _, _) =>
        write(s"$messageString")
      case (ps: IPreparedStatement, "executeQuery" | "executeUpdate" | "execute" | "addBatch", (), _) =>
        write(s"$messageString${makeBindInfoString(ps)}")
      case (_: IStatement, "executeQuery" | "executeUpdate" | "execute" | "executeBatch", _, _) =>
        write(s"$messageString")
      case (_: IStatement, "addBatch", Tuple1(_), _) =>
        write(s"$messageString")
      case _ =>
    }

    result
  }
}

