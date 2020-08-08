package ice.jdbc

import java.io.{InputStream, Reader}
import java.net.URL
import java.sql.{Array => _, _}
import java.util
import java.util.Calendar

class ICallableStatement(connection: IConnection, val callableStatement: CallableStatement, sql: String) extends IPreparedStatement(connection, callableStatement, sql) with CallableStatement {

  override def registerOutParameter(parameterIndex: Int, sqlType: Int): Unit = withExtraWork("registerOutParameter", (parameterIndex, sqlType)) { case (parameterIndex, sqlType) =>
    callableStatement.registerOutParameter(parameterIndex, sqlType)
  }

  override def registerOutParameter(parameterIndex: Int, sqlType: Int, scale: Int): Unit = withExtraWork("registerOutParameter", (parameterIndex, sqlType, scale)) { case (parameterIndex, sqlType, scale) =>
    callableStatement.registerOutParameter(parameterIndex, sqlType, scale)
  }

  override def wasNull(): Boolean = withExtraWork("wasNull") { _ =>
    callableStatement.wasNull()
  }

  override def getString(parameterIndex: Int): String = withExtraWork("getString", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getString(parameterIndex)
  }

  override def getBoolean(parameterIndex: Int): Boolean = withExtraWork("getBoolean", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getBoolean(parameterIndex)
  }

  override def getByte(parameterIndex: Int): Byte = withExtraWork("getByte", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getByte(parameterIndex)
  }

  override def getShort(parameterIndex: Int): Short = withExtraWork("getShort", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getShort(parameterIndex)
  }

  override def getInt(parameterIndex: Int): Int = withExtraWork("getInt", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getInt(parameterIndex)
  }

  override def getLong(parameterIndex: Int): Long = withExtraWork("getLong", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getLong(parameterIndex)
  }

  override def getFloat(parameterIndex: Int): Float = withExtraWork("getFloat", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getFloat(parameterIndex)
  }

  override def getDouble(parameterIndex: Int): Double = withExtraWork("getDouble", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getDouble(parameterIndex)
  }

  @deprecated override def getBigDecimal(parameterIndex: Int, scale: Int): java.math.BigDecimal = withExtraWork("getBigDecimal", (parameterIndex, scale)) { case (parameterIndex, scale) =>
    callableStatement.getBigDecimal(parameterIndex, scale)
  }

  override def getBytes(parameterIndex: Int): Array[Byte] = withExtraWork("getBytes", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getBytes(parameterIndex)
  }

  override def getDate(parameterIndex: Int): Date = withExtraWork("getDate", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getDate(parameterIndex)
  }

  override def getTime(parameterIndex: Int): Time = withExtraWork("getTime", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getTime(parameterIndex)
  }

  override def getTimestamp(parameterIndex: Int): Timestamp = withExtraWork("getTimestamp", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getTimestamp(parameterIndex)
  }

  override def getObject(parameterIndex: Int): AnyRef = withExtraWork("getObject", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getObject(parameterIndex)
  }

  override def getBigDecimal(parameterIndex: Int): java.math.BigDecimal = withExtraWork("getBigDecimal", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getBigDecimal(parameterIndex)
  }

  override def getObject(parameterIndex: Int, map: util.Map[String, Class[_]]): AnyRef = withExtraWork("getObject", (parameterIndex, map)) { case (parameterIndex, map) =>
    callableStatement.getObject(parameterIndex, map)
  }

  override def getRef(parameterIndex: Int): Ref = withExtraWork("getRef", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getRef(parameterIndex)
  }

  override def getBlob(parameterIndex: Int): Blob = withExtraWork("getBlob", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getBlob(parameterIndex)
  }

  override def getClob(parameterIndex: Int): Clob = withExtraWork("getClob", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getClob(parameterIndex)
  }

  override def getArray(parameterIndex: Int): java.sql.Array = withExtraWork("getArray", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getArray(parameterIndex)
  }

  override def getDate(parameterIndex: Int, cal: Calendar): Date = withExtraWork("getDate", (parameterIndex, cal)) { case (parameterIndex, cal) =>
    callableStatement.getDate(parameterIndex, cal)
  }

  override def getTime(parameterIndex: Int, cal: Calendar): Time = withExtraWork("getTime", (parameterIndex, cal)) { case (parameterIndex, cal) =>
    callableStatement.getTime(parameterIndex, cal)
  }

  override def getTimestamp(parameterIndex: Int, cal: Calendar): Timestamp = withExtraWork("getTimestamp", (parameterIndex, cal)) { case (parameterIndex, cal) =>
    callableStatement.getTimestamp(parameterIndex, cal)
  }

  override def registerOutParameter(parameterIndex: Int, sqlType: Int, typeName: String): Unit = withExtraWork("registerOutParameter", (parameterIndex, sqlType, typeName)) { case (parameterIndex, sqlType, typeName) =>
    callableStatement.registerOutParameter(parameterIndex, sqlType, typeName)
  }

  override def registerOutParameter(parameterName: String, sqlType: Int): Unit = withExtraWork("registerOutParameter", (parameterName, sqlType)) { case (parameterName, sqlType) =>
    callableStatement.registerOutParameter(parameterName, sqlType)
  }

  override def registerOutParameter(parameterName: String, sqlType: Int, scale: Int): Unit = withExtraWork("registerOutParameter", (parameterName, sqlType, scale)) { case (parameterName, sqlType, scale) =>
    callableStatement.registerOutParameter(parameterName, sqlType, scale)
  }

  override def registerOutParameter(parameterName: String, sqlType: Int, typeName: String): Unit = withExtraWork("registerOutParameter", (parameterName, sqlType, typeName)) { case (parameterName, sqlType, typeName) =>
    callableStatement.registerOutParameter(parameterName, sqlType, typeName)
  }

  override def getURL(parameterIndex: Int): URL = withExtraWork("getURL", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getURL(parameterIndex)
  }

  override def setURL(parameterName: String, `val`: URL): Unit = withExtraWork("setURL", (parameterName, `val`)) { case (parameterName, value) =>
    callableStatement.setURL(parameterName, value)
  }

  override def setNull(parameterName: String, sqlType: Int): Unit = withExtraWork("setNull", (parameterName, sqlType)) { case (parameterName, sqlType) =>
    callableStatement.setNull(parameterName, sqlType)
  }

  override def setBoolean(parameterName: String, x: Boolean): Unit = withExtraWork("setBoolean", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setBoolean(parameterName, x)
  }

  override def setByte(parameterName: String, x: Byte): Unit = withExtraWork("setByte", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setByte(parameterName, x)
  }

  override def setShort(parameterName: String, x: Short): Unit = withExtraWork("setShort", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setShort(parameterName, x)
  }

  override def setInt(parameterName: String, x: Int): Unit = withExtraWork("setInt", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setInt(parameterName, x)
  }

  override def setLong(parameterName: String, x: Long): Unit = withExtraWork("setLong", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setLong(parameterName, x)
  }

  override def setFloat(parameterName: String, x: Float): Unit = withExtraWork("setFloat", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setFloat(parameterName, x)
  }

  override def setDouble(parameterName: String, x: Double): Unit = withExtraWork("setDouble", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setDouble(parameterName, x)
  }

  override def setBigDecimal(parameterName: String, x: java.math.BigDecimal): Unit = withExtraWork("setBigDecimal", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setBigDecimal(parameterName, x)
  }

  override def setString(parameterName: String, x: String): Unit = withExtraWork("setString", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setString(parameterName, x)
  }

  override def setBytes(parameterName: String, x: Array[Byte]): Unit = withExtraWork("setBytes", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setBytes(parameterName, x)
  }

  override def setDate(parameterName: String, x: Date): Unit = withExtraWork("setDate", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setDate(parameterName, x)
  }

  override def setTime(parameterName: String, x: Time): Unit = withExtraWork("setTime", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setTime(parameterName, x)
  }

  override def setTimestamp(parameterName: String, x: Timestamp): Unit = withExtraWork("setTimestamp", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setTimestamp(parameterName, x)
  }

  override def setAsciiStream(parameterName: String, x: InputStream, length: Int): Unit = withExtraWork("setAsciiStream", (parameterName, x, length)) { case (parameterName, x, length) =>
    callableStatement.setAsciiStream(parameterName, x, length)
  }

  override def setBinaryStream(parameterName: String, x: InputStream, length: Int): Unit = withExtraWork("setBinaryStream", (parameterName, x, length)) { case (parameterName, x, length) =>
    callableStatement.setBinaryStream(parameterName, x, length)
  }

  override def setObject(parameterName: String, x: Any, targetSqlType: Int, scale: Int): Unit = withExtraWork("setObject", (parameterName, x, targetSqlType, scale)) { case (parameterName, x, targetSqlType, scale) =>
    callableStatement.setObject(parameterName, x, targetSqlType, scale)
  }

  override def setObject(parameterName: String, x: Any, targetSqlType: Int): Unit = withExtraWork("setObject", (parameterName, x, targetSqlType)) { case (parameterName, x, targetSqlType) =>
    callableStatement.setObject(parameterName, x, targetSqlType)
  }

  override def setObject(parameterName: String, x: Any): Unit = withExtraWork("setObject", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setObject(parameterName, x)
  }

  override def setCharacterStream(parameterName: String, reader: Reader, length: Int): Unit = withExtraWork("setCharacterStream", (parameterName, reader, length)) { case (parameterName, reader, length) =>
    callableStatement.setCharacterStream(parameterName, reader, length)
  }

  override def setDate(parameterName: String, x: Date, cal: Calendar): Unit = withExtraWork("setDate", (parameterName, x, cal)) { case (parameterName, x, cal) =>
    callableStatement.setDate(parameterName, x, cal)
  }

  override def setTime(parameterName: String, x: Time, cal: Calendar): Unit = withExtraWork("setTime", (parameterName, x, cal)) { case (parameterName, x, cal) =>
    callableStatement.setTime(parameterName, x, cal)
  }

  override def setTimestamp(parameterName: String, x: Timestamp, cal: Calendar): Unit = withExtraWork("setTimestamp", (parameterName, x, cal)) { case (parameterName, x, cal) =>
    callableStatement.setTimestamp(parameterName, x, cal)
  }

  override def setNull(parameterName: String, sqlType: Int, typeName: String): Unit = withExtraWork("setNull", (parameterName, sqlType, typeName)) { case (parameterName, sqlType, typeName) =>
    callableStatement.setNull(parameterName, sqlType, typeName)
  }

  override def getString(parameterName: String): String = withExtraWork("getString", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getString(parameterName)
  }

  override def getBoolean(parameterName: String): Boolean = withExtraWork("getBoolean", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getBoolean(parameterName)
  }

  override def getByte(parameterName: String): Byte = withExtraWork("getByte", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getByte(parameterName)
  }

  override def getShort(parameterName: String): Short = withExtraWork("getShort", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getShort(parameterName)
  }

  override def getInt(parameterName: String): Int = withExtraWork("getInt", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getInt(parameterName)
  }

  override def getLong(parameterName: String): Long = withExtraWork("getLong", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getLong(parameterName)
  }

  override def getFloat(parameterName: String): Float = withExtraWork("getFloat", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getFloat(parameterName)
  }

  override def getDouble(parameterName: String): Double = withExtraWork("getDouble", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getDouble(parameterName)
  }

  override def getBytes(parameterName: String): Array[Byte] = withExtraWork("getBytes", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getBytes(parameterName)
  }

  override def getDate(parameterName: String): Date = withExtraWork("getDate", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getDate(parameterName)
  }

  override def getTime(parameterName: String): Time = withExtraWork("getTime", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getTime(parameterName)
  }

  override def getTimestamp(parameterName: String): Timestamp = withExtraWork("getTimestamp", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getTimestamp(parameterName)
  }

  override def getObject(parameterName: String): AnyRef = withExtraWork("getObject", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getObject(parameterName)
  }

  override def getBigDecimal(parameterName: String): java.math.BigDecimal = withExtraWork("getBigDecimal", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getBigDecimal(parameterName)
  }

  override def getObject(parameterName: String, map: util.Map[String, Class[_]]): AnyRef = withExtraWork("getObject", (parameterName, map)) { case (parameterName, map) =>
    callableStatement.getObject(parameterName, map)
  }

  override def getRef(parameterName: String): Ref = withExtraWork("getRef", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getRef(parameterName)
  }

  override def getBlob(parameterName: String): Blob = withExtraWork("getBlob", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getBlob(parameterName)
  }

  override def getClob(parameterName: String): Clob = withExtraWork("getClob", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getClob(parameterName)
  }

  override def getArray(parameterName: String): java.sql.Array = withExtraWork("getArray", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getArray(parameterName)
  }

  override def getDate(parameterName: String, cal: Calendar): Date = withExtraWork("getDate", (parameterName, cal)) { case (parameterName, cal) =>
    callableStatement.getDate(parameterName, cal)
  }

  override def getTime(parameterName: String, cal: Calendar): Time = withExtraWork("getTime", (parameterName, cal)) { case (parameterName, cal) =>
    callableStatement.getTime(parameterName, cal)
  }

  override def getTimestamp(parameterName: String, cal: Calendar): Timestamp = withExtraWork("getTimestamp", (parameterName, cal)) { case (parameterName, cal) =>
    callableStatement.getTimestamp(parameterName, cal)
  }

  override def getURL(parameterName: String): URL = withExtraWork("getURL", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getURL(parameterName)
  }

  override def getRowId(parameterIndex: Int): RowId = withExtraWork("getRowId", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getRowId(parameterIndex)
  }

  override def getRowId(parameterName: String): RowId = withExtraWork("getRowId", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getRowId(parameterName)
  }

  override def setRowId(parameterName: String, x: RowId): Unit = withExtraWork("setRowId", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setRowId(parameterName, x)
  }

  override def setNString(parameterName: String, value: String): Unit = withExtraWork("setNString", (parameterName, value)) { case (parameterName, value) =>
    callableStatement.setNString(parameterName, value)
  }

  override def setNCharacterStream(parameterName: String, value: Reader, length: Long): Unit = withExtraWork("setNCharacterStream", (parameterName, value, length)) { case (parameterName, value, length) =>
    callableStatement.setNCharacterStream(parameterName, value, length)
  }

  override def setNClob(parameterName: String, value: NClob): Unit = withExtraWork("setNClob", (parameterName, value)) { case (parameterName, value) =>
    callableStatement.setNClob(parameterName, value)
  }

  override def setClob(parameterName: String, reader: Reader, length: Long): Unit = withExtraWork("setClob", (parameterName, reader, length)) { case (parameterName, reader, length) =>
    callableStatement.setClob(parameterName, reader, length)
  }

  override def setBlob(parameterName: String, inputStream: InputStream, length: Long): Unit = withExtraWork("setBlob", (parameterName, inputStream, length)) { case (parameterName, inputStream, length) =>
    callableStatement.setBlob(parameterName, inputStream, length)
  }

  override def setNClob(parameterName: String, reader: Reader, length: Long): Unit = withExtraWork("setNClob", (parameterName, reader, length)) { case (parameterName, reader, length) =>
    callableStatement.setNClob(parameterName, reader, length)
  }

  override def getNClob(parameterIndex: Int): NClob = withExtraWork("getNClob", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getNClob(parameterIndex)
  }

  override def getNClob(parameterName: String): NClob = withExtraWork("getNClob", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getNClob(parameterName)
  }

  override def setSQLXML(parameterName: String, xmlObject: SQLXML): Unit = withExtraWork("setSQLXML", (parameterName, xmlObject)) { case (parameterName, xmlObject) =>
    callableStatement.setSQLXML(parameterName, xmlObject)
  }

  override def getSQLXML(parameterIndex: Int): SQLXML = withExtraWork("getSQLXML", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getSQLXML(parameterIndex)
  }

  override def getSQLXML(parameterName: String): SQLXML = withExtraWork("getSQLXML", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getSQLXML(parameterName)
  }

  override def getNString(parameterIndex: Int): String = withExtraWork("getNString", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getNString(parameterIndex)
  }

  override def getNString(parameterName: String): String = withExtraWork("getNString", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getNString(parameterName)
  }

  override def getNCharacterStream(parameterIndex: Int): Reader = withExtraWork("getNCharacterStream", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getNCharacterStream(parameterIndex)
  }

  override def getNCharacterStream(parameterName: String): Reader = withExtraWork("getNCharacterStream", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getNCharacterStream(parameterName)
  }

  override def getCharacterStream(parameterIndex: Int): Reader = withExtraWork("getCharacterStream", Tuple1(parameterIndex)) { case Tuple1(parameterIndex) =>
    callableStatement.getCharacterStream(parameterIndex)
  }

  override def getCharacterStream(parameterName: String): Reader = withExtraWork("getCharacterStream", Tuple1(parameterName)) { case Tuple1(parameterName) =>
    callableStatement.getCharacterStream(parameterName)
  }

  override def setBlob(parameterName: String, x: Blob): Unit = withExtraWork("setBlob", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setBlob(parameterName, x)
  }

  override def setClob(parameterName: String, x: Clob): Unit = withExtraWork("setClob", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setClob(parameterName, x)
  }

  override def setAsciiStream(parameterName: String, x: InputStream, length: Long): Unit = withExtraWork("setAsciiStream", (parameterName, x, length)) { case (parameterName, x, length) =>
    callableStatement.setAsciiStream(parameterName, x, length)
  }

  override def setBinaryStream(parameterName: String, x: InputStream, length: Long): Unit = withExtraWork("setBinaryStream", (parameterName, x, length)) { case (parameterName, x, length) =>
    callableStatement.setBinaryStream(parameterName, x, length)
  }

  override def setCharacterStream(parameterName: String, reader: Reader, length: Long): Unit = withExtraWork("setCharacterStream", (parameterName, reader, length)) { case (parameterName, reader, length) =>
    callableStatement.setCharacterStream(parameterName, reader, length)
  }

  override def setAsciiStream(parameterName: String, x: InputStream): Unit = withExtraWork("setAsciiStream", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setAsciiStream(parameterName, x)
  }

  override def setBinaryStream(parameterName: String, x: InputStream): Unit = withExtraWork("setBinaryStream", (parameterName, x)) { case (parameterName, x) =>
    callableStatement.setBinaryStream(parameterName, x)
  }

  override def setCharacterStream(parameterName: String, reader: Reader): Unit = withExtraWork("setCharacterStream", (parameterName, reader)) { case (parameterName, reader) =>
    callableStatement.setCharacterStream(parameterName, reader)
  }

  override def setNCharacterStream(parameterName: String, value: Reader): Unit = withExtraWork("setNCharacterStream", (parameterName, value)) { case (parameterName, value) =>
    callableStatement.setNCharacterStream(parameterName, value)
  }

  override def setClob(parameterName: String, reader: Reader): Unit = withExtraWork("setClob", (parameterName, reader)) { case (parameterName, reader) =>
    callableStatement.setClob(parameterName, reader)
  }

  override def setBlob(parameterName: String, inputStream: InputStream): Unit = withExtraWork("setBlob", (parameterName, inputStream)) { case (parameterName, inputStream) =>
    callableStatement.setBlob(parameterName, inputStream)
  }

  override def setNClob(parameterName: String, reader: Reader): Unit = withExtraWork("setNClob", (parameterName, reader)) { case (parameterName, reader) =>
    callableStatement.setNClob(parameterName, reader)
  }

  override def getObject[T](parameterIndex: Int, `type`: Class[T]): T = withExtraWork("getObject", (parameterIndex, `type`)) { case (parameterIndex, typ) =>
    callableStatement.getObject(parameterIndex, typ)
  }

  override def getObject[T](parameterName: String, `type`: Class[T]): T = withExtraWork(" getObject", (parameterName, `type`)) { case (parameterName, typ) =>
    callableStatement.getObject(parameterName, typ)
  }
}
