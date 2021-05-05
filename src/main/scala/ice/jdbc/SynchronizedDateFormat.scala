package ice.jdbc

import java.text.{DateFormatSymbols, FieldPosition, SimpleDateFormat}
import java.util.{Date, Locale}

object SynchronizedDateFormat {
  val DateTimeMllis: SimpleDateFormat = SynchronizedDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
  val DateTime: SimpleDateFormat = SynchronizedDateFormat("yyyy/MM/dd HH:mm:ss")

  private def apply(pattern: String): SimpleDateFormat = new SimpleDateFormat(pattern, Locale.UK) with SynchronizedDateFormat
}

private trait SynchronizedDateFormat extends SimpleDateFormat {
  override def parse(source: String): Date = synchronized {
    super.parse(source)
  }

  override def format(date: Date, toAppendTo: StringBuffer, pos: FieldPosition): StringBuffer = synchronized {
    super.format(date, toAppendTo, pos)
  }
}
