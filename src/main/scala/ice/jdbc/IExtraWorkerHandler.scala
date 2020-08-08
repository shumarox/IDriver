package ice.jdbc

import scala.beans.BeanProperty

object IExtraWorkerHandler {
  @BeanProperty
  var extraWorker: IExtraWorker = StandardLogWorker
}

trait IExtraWorkerHandler {

  import IExtraWorkerHandler._

  protected def withExtraWork[A, R](name: String, args: A = ())(func: A => R): R = {
    val newArgs =
      extraWorker.processArguments(this, name, args) match {
        case Right(newArgs) =>
          newArgs.asInstanceOf[A]
        case Left(th) =>
          throw th
      }

    val start = System.currentTimeMillis()

    val result =
      try {
        func(newArgs)
      } catch {
        case th: Throwable =>
          extraWorker.processResult(this, name, args, Left(th), System.currentTimeMillis() - start) match {
            case Right(result) =>
              return result.asInstanceOf[R]
            case Left(th) =>
              throw th
          }
      }

    extraWorker.processResult(this, name, args, Right(result), System.currentTimeMillis() - start) match {
      case Right(result) =>
        result.asInstanceOf[R]
      case Left(th) =>
        throw th
    }
  }
}
