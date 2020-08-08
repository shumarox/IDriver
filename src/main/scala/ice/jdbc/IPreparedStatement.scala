package ice.jdbc

import java.io.{InputStream, Reader}
import java.net.URL
import java.sql.{Array => _, _}
import java.text.SimpleDateFormat
import java.util.{Calendar, Locale}

import scala.collection.mutable

class IPreparedStatement(connection: IConnection, val preparedStatement: PreparedStatement, val sql: String)
  extends IStatement(connection, preparedStatement) with PreparedStatement with IBindValueHolder {

  override def close(): Unit = withExtraWork("close") { _ =>
    clearAllBindValues(); preparedStatement.close()
  }

  override def executeQuery(): ResultSet = withExtraWork("executeQuery") { _ =>
    moveTempBindValuesToUsed(); createWrappedResultSet(preparedStatement.executeQuery())
  }

  override def executeUpdate(): Int = withExtraWork("executeUpdate") { _ =>
    moveTempBindValuesToUsed(); preparedStatement.executeUpdate()
  }

  override def setNull(parameterIndex: Int, sqlType: Int): Unit = withExtraWork("setNull", (parameterIndex, sqlType)) { case (parameterIndex, sqlType) =>
    putTempBindValue(parameterIndex, null); preparedStatement.setNull(parameterIndex, sqlType)
  }

  override def setBoolean(parameterIndex: Int, x: Boolean): Unit = withExtraWork("setBoolean", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setBoolean(parameterIndex, x)
  }

  override def setByte(parameterIndex: Int, x: Byte): Unit = withExtraWork("setByte", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setByte(parameterIndex, x)
  }

  override def setShort(parameterIndex: Int, x: Short): Unit = withExtraWork("setShort", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setShort(parameterIndex, x)
  }

  override def setInt(parameterIndex: Int, x: Int): Unit = withExtraWork("setInt", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setInt(parameterIndex, x)
  }

  override def setLong(parameterIndex: Int, x: Long): Unit = withExtraWork("setLong", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setLong(parameterIndex, x)
  }

  override def setFloat(parameterIndex: Int, x: Float): Unit = withExtraWork("setFloat", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setFloat(parameterIndex, x)
  }

  override def setDouble(parameterIndex: Int, x: Double): Unit = withExtraWork("setDouble", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setDouble(parameterIndex, x)
  }

  override def setBigDecimal(parameterIndex: Int, x: java.math.BigDecimal): Unit = withExtraWork("setBigDecimal", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setBigDecimal(parameterIndex, x)
  }

  override def setString(parameterIndex: Int, x: String): Unit = withExtraWork("setString", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setString(parameterIndex, x)
  }

  override def setBytes(parameterIndex: Int, x: Array[Byte]): Unit = withExtraWork("setBytes", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setBytes(parameterIndex, x)
  }

  override def setDate(parameterIndex: Int, x: Date): Unit = withExtraWork("setDate", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setDate(parameterIndex, x)
  }

  override def setTime(parameterIndex: Int, x: Time): Unit = withExtraWork("setTime", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setTime(parameterIndex, x)
  }

  override def setTimestamp(parameterIndex: Int, x: Timestamp): Unit = withExtraWork("setTimestamp", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setTimestamp(parameterIndex, x)
  }

  override def setAsciiStream(parameterIndex: Int, x: InputStream, length: Int): Unit = withExtraWork("setAsciiStream", (parameterIndex, x, length)) { case (parameterIndex, x, length) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setAsciiStream(parameterIndex, x, length)
  }

  @deprecated override def setUnicodeStream(parameterIndex: Int, x: InputStream, length: Int): Unit = withExtraWork("setUnicodeStream", (parameterIndex, x, length)) { case (parameterIndex, x, length) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setUnicodeStream(parameterIndex, x, length)
  }

  override def setBinaryStream(parameterIndex: Int, x: InputStream, length: Int): Unit = withExtraWork("setBinaryStream", (parameterIndex, x, length)) { case (parameterIndex, x, length) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setBinaryStream(parameterIndex, x, length)
  }

  override def clearParameters(): Unit = withExtraWork("clearParameters") { _ =>
    clearTempBindValues(); preparedStatement.clearParameters()
  }

  override def setObject(parameterIndex: Int, x: Any, targetSqlType: Int): Unit = withExtraWork("setObject", (parameterIndex, x, targetSqlType)) { case (parameterIndex, x, targetSqlType) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setObject(parameterIndex, x, targetSqlType)
  }

  override def setObject(parameterIndex: Int, x: Any): Unit = withExtraWork("setObject", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setObject(parameterIndex, x)
  }

  override def execute(): Boolean = withExtraWork("execute") { _ =>
    moveTempBindValuesToUsed(); preparedStatement.execute()
  }

  override def addBatch(): Unit = withExtraWork("addBatch") { _ =>
    moveTempBindValuesToUsed(); preparedStatement.addBatch()
  }

  override def setCharacterStream(parameterIndex: Int, reader: Reader, length: Int): Unit = withExtraWork("setCharacterStream", (parameterIndex, reader, length)) { case (parameterIndex, reader, length) =>
    putTempBindValue(parameterIndex, reader); preparedStatement.setCharacterStream(parameterIndex, reader, length)
  }

  override def setRef(parameterIndex: Int, x: Ref): Unit = withExtraWork("setRef", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setRef(parameterIndex, x)
  }

  override def setBlob(parameterIndex: Int, x: Blob): Unit = withExtraWork("setBlob", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setBlob(parameterIndex, x)
  }

  override def setClob(parameterIndex: Int, x: Clob): Unit = withExtraWork("setClob", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setClob(parameterIndex, x)
  }

  override def setArray(parameterIndex: Int, x: java.sql.Array): Unit = withExtraWork("setArray", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setArray(parameterIndex, x)
  }

  override def getMetaData: ResultSetMetaData = withExtraWork("getMetaData") { _ =>
    preparedStatement.getMetaData
  }

  override def setDate(parameterIndex: Int, x: Date, cal: Calendar): Unit = withExtraWork("setDate", (parameterIndex, x, cal)) { case (parameterIndex, x, cal) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setDate(parameterIndex, x, cal)
  }

  override def setTime(parameterIndex: Int, x: Time, cal: Calendar): Unit = withExtraWork("setTime", (parameterIndex, x, cal)) { case (parameterIndex, x, cal) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setTime(parameterIndex, x, cal)
  }

  override def setTimestamp(parameterIndex: Int, x: Timestamp, cal: Calendar): Unit = withExtraWork("setTimestamp", (parameterIndex, x, cal)) { case (parameterIndex, x, cal) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setTimestamp(parameterIndex, x, cal)
  }

  override def setNull(parameterIndex: Int, sqlType: Int, typeName: String): Unit = withExtraWork("setNull", (parameterIndex, sqlType, typeName)) { case (parameterIndex, sqlType, typeName) =>
    putTempBindValue(parameterIndex, null); preparedStatement.setNull(parameterIndex, sqlType, typeName)
  }

  override def setURL(parameterIndex: Int, x: URL): Unit = withExtraWork("setURL", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setURL(parameterIndex, x)
  }

  override def getParameterMetaData: ParameterMetaData = withExtraWork("getParameterMetaData") { _ =>
    preparedStatement.getParameterMetaData
  }

  override def setRowId(parameterIndex: Int, x: RowId): Unit = withExtraWork("setRowId", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setRowId(parameterIndex, x)
  }

  override def setNString(parameterIndex: Int, value: String): Unit = withExtraWork("setNString", (parameterIndex, value)) { case (parameterIndex, value) =>
    putTempBindValue(parameterIndex, value); preparedStatement.setNString(parameterIndex, value)
  }

  override def setNCharacterStream(parameterIndex: Int, value: Reader, length: Long): Unit = withExtraWork("setNCharacterStream", (parameterIndex, value, length)) { case (parameterIndex, value, length) =>
    putTempBindValue(parameterIndex, value); preparedStatement.setNCharacterStream(parameterIndex, value, length)
  }

  override def setNClob(parameterIndex: Int, value: NClob): Unit = withExtraWork("setNClob", (parameterIndex, value)) { case (parameterIndex, value) =>
    putTempBindValue(parameterIndex, value); preparedStatement.setNClob(parameterIndex, value)
  }

  override def setClob(parameterIndex: Int, reader: Reader, length: Long): Unit = withExtraWork("setClob", (parameterIndex, reader, length)) { case (parameterIndex, reader, length) =>
    putTempBindValue(parameterIndex, reader); preparedStatement.setClob(parameterIndex, reader, length)
  }

  override def setBlob(parameterIndex: Int, inputStream: InputStream, length: Long): Unit = withExtraWork("setBlob", (parameterIndex, inputStream, length)) { case (parameterIndex, inputStream, length) =>
    putTempBindValue(parameterIndex, inputStream); preparedStatement.setBlob(parameterIndex, inputStream, length)
  }

  override def setNClob(parameterIndex: Int, reader: Reader, length: Long): Unit = withExtraWork("setNClob", (parameterIndex, reader, length)) { case (parameterIndex, reader, length) =>
    putTempBindValue(parameterIndex, reader); preparedStatement.setNClob(parameterIndex, reader, length)
  }

  override def setSQLXML(parameterIndex: Int, xmlObject: SQLXML): Unit = withExtraWork("setSQLXML", (parameterIndex, xmlObject)) { case (parameterIndex, xmlObject) =>
    putTempBindValue(parameterIndex, xmlObject); preparedStatement.setSQLXML(parameterIndex, xmlObject)
  }

  override def setObject(parameterIndex: Int, x: Any, targetSqlType: Int, scaleOrLength: Int): Unit = withExtraWork("setObject", (parameterIndex, x, targetSqlType, scaleOrLength)) { case (parameterIndex, x, targetSqlType, scaleOrLength) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength)
  }

  override def setAsciiStream(parameterIndex: Int, x: InputStream, length: Long): Unit = withExtraWork("setAsciiStream", (parameterIndex, x, length)) { case (parameterIndex, x, length) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setAsciiStream(parameterIndex, x, length)
  }

  override def setBinaryStream(parameterIndex: Int, x: InputStream, length: Long): Unit = withExtraWork("setBinaryStream", (parameterIndex, x, length)) { case (parameterIndex, x, length) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setBinaryStream(parameterIndex, x, length)
  }

  override def setCharacterStream(parameterIndex: Int, reader: Reader, length: Long): Unit = withExtraWork("setCharacterStream", (parameterIndex, reader, length)) { case (parameterIndex, reader, length) =>
    putTempBindValue(parameterIndex, reader); preparedStatement.setCharacterStream(parameterIndex, reader, length)
  }

  override def setAsciiStream(parameterIndex: Int, x: InputStream): Unit = withExtraWork("setAsciiStream", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setAsciiStream(parameterIndex, x)
  }

  override def setBinaryStream(parameterIndex: Int, x: InputStream): Unit = withExtraWork("setBinaryStream", (parameterIndex, x)) { case (parameterIndex, x) =>
    putTempBindValue(parameterIndex, x); preparedStatement.setBinaryStream(parameterIndex, x)
  }

  override def setCharacterStream(parameterIndex: Int, reader: Reader): Unit = withExtraWork("setCharacterStream", (parameterIndex, reader)) { case (parameterIndex, reader) =>
    putTempBindValue(parameterIndex, reader); preparedStatement.setCharacterStream(parameterIndex, reader)
  }

  override def setNCharacterStream(parameterIndex: Int, value: Reader): Unit = withExtraWork("setNCharacterStream", (parameterIndex, value)) { case (parameterIndex, value) =>
    putTempBindValue(parameterIndex, value); preparedStatement.setNCharacterStream(parameterIndex, value)
  }

  override def setClob(parameterIndex: Int, reader: Reader): Unit = withExtraWork("setClob", (parameterIndex, reader)) { case (parameterIndex, reader) =>
    putTempBindValue(parameterIndex, reader); preparedStatement.setClob(parameterIndex, reader)
  }

  override def setBlob(parameterIndex: Int, inputStream: InputStream): Unit = withExtraWork("setBlob", (parameterIndex, inputStream)) { case (parameterIndex, inputStream) =>
    putTempBindValue(parameterIndex, inputStream); preparedStatement.setBlob(parameterIndex, inputStream)
  }

  override def setNClob(parameterIndex: Int, reader: Reader): Unit = withExtraWork("setNClob", (parameterIndex, reader)) { case (parameterIndex, reader) =>
    putTempBindValue(parameterIndex, reader); preparedStatement.setNClob(parameterIndex, reader)
  }
}

trait IBindValueHolder {
  self: IPreparedStatement =>

  private var _tempBindValues: mutable.TreeMap[Int, Any] = new mutable.TreeMap[Int, Any]
  private var _usedBindValues: mutable.TreeMap[Int, Any] = _

  def isTempBindValuesEmpty: Boolean = _tempBindValues.isEmpty

  def isUsedBindValuesEmpty: Boolean = _usedBindValues.isEmpty

  def tempBindValues: List[Any] = _tempBindValues.values.toList

  def usedBindValues: List[Any] = _usedBindValues.values.toList

  def tempBindValueStrings: List[Any] = _tempBindValues.values.map(toString).toList

  def usedBindValueStrings: List[Any] = _usedBindValues.values.map(toString).toList

  def tempBindValueClassNames: List[Any] = _tempBindValues.values.map(getClassName).toList

  def usedBindValueClassNames: List[Any] = _usedBindValues.values.map(getClassName).toList

  protected def putTempBindValue(index: Int, x: Any): Unit = {
    _tempBindValues.put(index, x)
  }

  protected def clearTempBindValues(): Unit = {
    _tempBindValues = new mutable.TreeMap[Int, Any]
  }

  protected def clearAllBindValues(): Unit = {
    _tempBindValues = new mutable.TreeMap[Int, Any]
    _usedBindValues = new mutable.TreeMap[Int, Any]
  }

  protected def moveTempBindValuesToUsed(): Unit = {
    _usedBindValues = _tempBindValues
    clearTempBindValues()
  }

  private def toString(value: Any): String = {
    value match {
      case null =>
        "null"
      case s: String =>
        s.replaceAll("'", "''")
      case t: Timestamp =>
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.UK).format(t)
      case d: Date =>
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.UK).format(d)
      case _ =>
        value.toString
    }
  }

  private def getClassName(value: Any): String = Option(value).map(_.getClass.getName).getOrElse("null")

  private def escape(value: Any): String = {
    value match {
      case null =>
        "null"
      case s: String =>
        "'" + s.replaceAll("'", "''") + "'"
      case t: Timestamp =>
        "'" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.UK).format(t) + "'"
      case d: Date =>
        "'" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.UK).format(d) + "'"
      case _ =>
        value.toString
    }
  }

  private def makeBindValueEmbeddedSql(bindValues: mutable.TreeMap[Int, Any]): String = {
    val embedded = sql.split("\\?").zipWithIndex.map { case (s, i) => s + bindValues.get(i + 1).map(escape).getOrElse("?") }.mkString
    if (sql.last != '?' && embedded.last == '?') embedded.init else embedded
  }

  def makeTempBindValueEmbeddedSql: String = makeBindValueEmbeddedSql(_tempBindValues)

  def makeUsedBindValueEmbeddedSql: String = makeBindValueEmbeddedSql(_usedBindValues)
}
