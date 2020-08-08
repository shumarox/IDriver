package ice.jdbc

import java.io.{InputStream, Reader}
import java.math.BigDecimal
import java.net.URL
import java.sql.{Array => _, _}
import java.util
import java.util.Calendar

class IResultSet(val statement: IStatement, val resultSet: ResultSet) extends ResultSet with IExtraWorkerHandler {

  override def toString: String = s"(i!)${resultSet.toString}"

  override def getString(index: Int): String = withExtraWork("getString", Tuple1(index)) { case Tuple1(index) =>
    resultSet.getString(index)
  }

  override def next(): Boolean = withExtraWork("next") { _ =>
    resultSet.next()
  }

  override def close(): Unit = withExtraWork("close") { _ =>
    resultSet.close()
  }

  override def wasNull(): Boolean = withExtraWork("wasNull") { _ =>
    resultSet.wasNull()
  }

  override def getBoolean(columnIndex: Int): Boolean = withExtraWork("getBoolean", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getBoolean(columnIndex)
  }

  override def getByte(columnIndex: Int): Byte = withExtraWork("getByte", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getByte(columnIndex)
  }

  override def getShort(columnIndex: Int): Short = withExtraWork("getShort", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getShort(columnIndex)
  }

  override def getInt(columnIndex: Int): Int = withExtraWork("getInt", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getInt(columnIndex)
  }

  override def getLong(columnIndex: Int): Long = withExtraWork("getLong", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getLong(columnIndex)
  }

  override def getFloat(columnIndex: Int): Float = withExtraWork("getFloat", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getFloat(columnIndex)
  }

  override def getDouble(columnIndex: Int): Double = withExtraWork("getDouble", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getDouble(columnIndex)
  }

  @deprecated override def getBigDecimal(columnIndex: Int, scale: Int): BigDecimal = withExtraWork("getBigDecimal", (columnIndex, scale)) { case (columnIndex, scale) =>
    resultSet.getBigDecimal(columnIndex, scale)
  }

  override def getBytes(columnIndex: Int): Array[Byte] = withExtraWork("getBytes", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getBytes(columnIndex)
  }

  override def getDate(columnIndex: Int): Date = withExtraWork("getDate", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getDate(columnIndex)
  }

  override def getTime(columnIndex: Int): Time = withExtraWork("getTime", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getTime(columnIndex)
  }

  override def getTimestamp(columnIndex: Int): Timestamp = withExtraWork("getTimestamp", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getTimestamp(columnIndex)
  }

  override def getAsciiStream(columnIndex: Int): InputStream = withExtraWork("getAsciiStream", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getAsciiStream(columnIndex)
  }

  @deprecated override def getUnicodeStream(columnIndex: Int): InputStream = withExtraWork("getUnicodeStream", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getUnicodeStream(columnIndex)
  }

  override def getBinaryStream(columnIndex: Int): InputStream = withExtraWork("getBinaryStream", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getBinaryStream(columnIndex)
  }

  override def getString(columnLabel: String): String = withExtraWork("getString", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getString(columnLabel)
  }

  override def getBoolean(columnLabel: String): Boolean = withExtraWork("getBoolean", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getBoolean(columnLabel)
  }

  override def getByte(columnLabel: String): Byte = withExtraWork("getByte", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getByte(columnLabel)
  }

  override def getShort(columnLabel: String): Short = withExtraWork("getShort", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getShort(columnLabel)
  }

  override def getInt(columnLabel: String): Int = withExtraWork("getInt", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getInt(columnLabel)
  }

  override def getLong(columnLabel: String): Long = withExtraWork("getLong", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getLong(columnLabel)
  }

  override def getFloat(columnLabel: String): Float = withExtraWork("getFloat", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getFloat(columnLabel)
  }

  override def getDouble(columnLabel: String): Double = withExtraWork("getDouble", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getDouble(columnLabel)
  }

  @deprecated override def getBigDecimal(columnLabel: String, scale: Int): BigDecimal = withExtraWork("getBigDecimal", (columnLabel, scale)) { case (columnLabel, scale) =>
    resultSet.getBigDecimal(columnLabel, scale)
  }

  override def getBytes(columnLabel: String): Array[Byte] = withExtraWork("getBytes", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getBytes(columnLabel)
  }

  override def getDate(columnLabel: String): Date = withExtraWork("getDate", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getDate(columnLabel)
  }

  override def getTime(columnLabel: String): Time = withExtraWork("getTime", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getTime(columnLabel)
  }

  override def getTimestamp(columnLabel: String): Timestamp = withExtraWork("getTimestamp", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getTimestamp(columnLabel)
  }

  override def getAsciiStream(columnLabel: String): InputStream = withExtraWork("getAsciiStream", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getAsciiStream(columnLabel)
  }

  @deprecated override def getUnicodeStream(columnLabel: String): InputStream = withExtraWork("getUnicodeStream", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getUnicodeStream(columnLabel)
  }

  override def getBinaryStream(columnLabel: String): InputStream = withExtraWork("getBinaryStream", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getBinaryStream(columnLabel)
  }

  override def getWarnings: SQLWarning = withExtraWork("getWarnings") { _ =>
    resultSet.getWarnings
  }

  override def clearWarnings(): Unit = withExtraWork("clearWarnings") { _ =>
    resultSet.clearWarnings()
  }

  override def getCursorName: String = withExtraWork("getCursorName") { _ =>
    resultSet.getCursorName
  }

  override def getMetaData: ResultSetMetaData = withExtraWork("getMetaData") { _ =>
    resultSet.getMetaData
  }

  override def getObject(columnIndex: Int): AnyRef = withExtraWork("getObject", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getObject(columnIndex)
  }

  override def getObject(columnLabel: String): AnyRef = withExtraWork("getObject", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getObject(columnLabel)
  }

  override def findColumn(columnLabel: String): Int = withExtraWork("findColumn", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.findColumn(columnLabel)
  }

  override def getCharacterStream(columnIndex: Int): Reader = withExtraWork("getCharacterStream", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getCharacterStream(columnIndex)
  }

  override def getCharacterStream(columnLabel: String): Reader = withExtraWork("getCharacterStream", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getCharacterStream(columnLabel)
  }

  override def getBigDecimal(columnIndex: Int): BigDecimal = withExtraWork("getBigDecimal", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getBigDecimal(columnIndex)
  }

  override def getBigDecimal(columnLabel: String): BigDecimal = withExtraWork("getBigDecimal", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getBigDecimal(columnLabel)
  }

  override def isBeforeFirst: Boolean = withExtraWork("isBeforeFirst") { _ =>
    resultSet.isBeforeFirst
  }

  override def isAfterLast: Boolean = withExtraWork("isAfterLast") { _ =>
    resultSet.isAfterLast
  }

  override def isFirst: Boolean = withExtraWork("isFirst") { _ =>
    resultSet.isFirst
  }

  override def isLast: Boolean = withExtraWork("isLast") { _ =>
    resultSet.isLast
  }

  override def beforeFirst(): Unit = withExtraWork("beforeFirst") { _ =>
    resultSet.beforeFirst()
  }

  override def afterLast(): Unit = withExtraWork("afterLast") { _ =>
    resultSet.afterLast()
  }

  override def first(): Boolean = withExtraWork("first") { _ =>
    resultSet.first()
  }

  override def last(): Boolean = withExtraWork("last") { _ =>
    resultSet.last()
  }

  override def getRow: Int = withExtraWork("getRow") { _ =>
    resultSet.getRow
  }

  override def absolute(row: Int): Boolean = withExtraWork("absolute", Tuple1(row)) { case Tuple1(row) =>
    resultSet.absolute(row)
  }

  override def relative(rows: Int): Boolean = withExtraWork("relative", Tuple1(rows)) { case Tuple1(rows) =>
    resultSet.relative(rows)
  }

  override def previous(): Boolean = withExtraWork("previous") { _ =>
    resultSet.previous()
  }

  override def setFetchDirection(direction: Int): Unit = withExtraWork("setFetchDirection", Tuple1(direction)) { case Tuple1(direction) =>
    resultSet.setFetchDirection(direction)
  }

  override def getFetchDirection: Int = withExtraWork("getFetchDirection") { _ =>
    resultSet.getFetchDirection
  }

  override def setFetchSize(rows: Int): Unit = withExtraWork("setFetchSize", Tuple1(rows)) { case Tuple1(rows) =>
    resultSet.setFetchSize(rows)
  }

  override def getFetchSize: Int = withExtraWork("getFetchSize") { _ =>
    resultSet.getFetchSize
  }

  override def getType: Int = withExtraWork("getType") { _ =>
    resultSet.getType
  }

  override def getConcurrency: Int = withExtraWork("getConcurrency") { _ =>
    resultSet.getConcurrency
  }

  override def rowUpdated(): Boolean = withExtraWork("rowUpdated") { _ =>
    resultSet.rowUpdated()
  }

  override def rowInserted(): Boolean = withExtraWork("rowInserted") { _ =>
    resultSet.rowInserted()
  }

  override def rowDeleted(): Boolean = withExtraWork("rowDeleted") { _ =>
    resultSet.rowDeleted()
  }

  override def updateNull(columnIndex: Int): Unit = withExtraWork("updateNull", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.updateNull(columnIndex)
  }

  override def updateBoolean(columnIndex: Int, x: Boolean): Unit = withExtraWork("updateBoolean", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateBoolean(columnIndex, x)
  }

  override def updateByte(columnIndex: Int, x: Byte): Unit = withExtraWork("updateByte", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateByte(columnIndex, x)
  }

  override def updateShort(columnIndex: Int, x: Short): Unit = withExtraWork("updateShort", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateShort(columnIndex, x)
  }

  override def updateInt(columnIndex: Int, x: Int): Unit = withExtraWork("updateInt", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateInt(columnIndex, x)
  }

  override def updateLong(columnIndex: Int, x: Long): Unit = withExtraWork("updateLong", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateLong(columnIndex, x)
  }

  override def updateFloat(columnIndex: Int, x: Float): Unit = withExtraWork("updateFloat", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateFloat(columnIndex, x)
  }

  override def updateDouble(columnIndex: Int, x: Double): Unit = withExtraWork("updateDouble", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateDouble(columnIndex, x)
  }

  override def updateBigDecimal(columnIndex: Int, x: BigDecimal): Unit = withExtraWork("updateBigDecimal", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateBigDecimal(columnIndex, x)
  }

  override def updateString(columnIndex: Int, x: String): Unit = withExtraWork("updateString", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateString(columnIndex, x)
  }

  override def updateBytes(columnIndex: Int, x: Array[Byte]): Unit = withExtraWork("updateBytes", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateBytes(columnIndex, x)
  }

  override def updateDate(columnIndex: Int, x: Date): Unit = withExtraWork("updateDate", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateDate(columnIndex, x)
  }

  override def updateTime(columnIndex: Int, x: Time): Unit = withExtraWork("updateTime", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateTime(columnIndex, x)
  }

  override def updateTimestamp(columnIndex: Int, x: Timestamp): Unit = withExtraWork("updateTimestamp", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateTimestamp(columnIndex, x)
  }

  override def updateAsciiStream(columnIndex: Int, x: InputStream, length: Int): Unit = withExtraWork("updateAsciiStream", (columnIndex, x, length)) { case (columnIndex, x, length) =>
    resultSet.updateAsciiStream(columnIndex, x, length)
  }

  override def updateBinaryStream(columnIndex: Int, x: InputStream, length: Int): Unit = withExtraWork("updateBinaryStream", (columnIndex, x, length)) { case (columnIndex, x, length) =>
    resultSet.updateBinaryStream(columnIndex, x, length)
  }

  override def updateCharacterStream(columnIndex: Int, x: Reader, length: Int): Unit = withExtraWork("updateCharacterStream", (columnIndex, x, length)) { case (columnIndex, x, length) =>
    resultSet.updateCharacterStream(columnIndex, x, length)
  }

  override def updateObject(columnIndex: Int, x: Any, scaleOrLength: Int): Unit = withExtraWork("updateObject", (columnIndex, x, scaleOrLength)) { case (columnIndex, x, scaleOrLength) =>
    resultSet.updateObject(columnIndex, x, scaleOrLength)
  }

  override def updateObject(columnIndex: Int, x: Any): Unit = withExtraWork("updateObject", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateObject(columnIndex, x)
  }

  override def updateNull(columnLabel: String): Unit = withExtraWork("updateNull", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.updateNull(columnLabel)
  }

  override def updateBoolean(columnLabel: String, x: Boolean): Unit = withExtraWork("updateBoolean", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateBoolean(columnLabel, x)
  }

  override def updateByte(columnLabel: String, x: Byte): Unit = withExtraWork("updateByte", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateByte(columnLabel, x)
  }

  override def updateShort(columnLabel: String, x: Short): Unit = withExtraWork("updateShort", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateShort(columnLabel, x)
  }

  override def updateInt(columnLabel: String, x: Int): Unit = withExtraWork("updateInt", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateInt(columnLabel, x)
  }

  override def updateLong(columnLabel: String, x: Long): Unit = withExtraWork("updateLong", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateLong(columnLabel, x)
  }

  override def updateFloat(columnLabel: String, x: Float): Unit = withExtraWork("updateFloat", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateFloat(columnLabel, x)
  }

  override def updateDouble(columnLabel: String, x: Double): Unit = withExtraWork("updateDouble", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateDouble(columnLabel, x)
  }

  override def updateBigDecimal(columnLabel: String, x: BigDecimal): Unit = withExtraWork("updateBigDecimal", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateBigDecimal(columnLabel, x)
  }

  override def updateString(columnLabel: String, x: String): Unit = withExtraWork("updateString", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateString(columnLabel, x)
  }

  override def updateBytes(columnLabel: String, x: Array[Byte]): Unit = withExtraWork("updateBytes", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateBytes(columnLabel, x)
  }

  override def updateDate(columnLabel: String, x: Date): Unit = withExtraWork("updateDate", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateDate(columnLabel, x)
  }

  override def updateTime(columnLabel: String, x: Time): Unit = withExtraWork("updateTime", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateTime(columnLabel, x)
  }

  override def updateTimestamp(columnLabel: String, x: Timestamp): Unit = withExtraWork("updateTimestamp", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateTimestamp(columnLabel, x)
  }

  override def updateAsciiStream(columnLabel: String, x: InputStream, length: Int): Unit = withExtraWork("updateAsciiStream", (columnLabel, x, length)) { case (columnLabel, x, length) =>
    resultSet.updateAsciiStream(columnLabel, x, length)
  }

  override def updateBinaryStream(columnLabel: String, x: InputStream, length: Int): Unit = withExtraWork("updateBinaryStream", (columnLabel, x, length)) { case (columnLabel, x, length) =>
    resultSet.updateBinaryStream(columnLabel, x, length)
  }

  override def updateCharacterStream(columnLabel: String, reader: Reader, length: Int): Unit = withExtraWork("updateCharacterStream", (columnLabel, reader, length)) { case (columnLabel, reader, length) =>
    resultSet.updateCharacterStream(columnLabel, reader, length)
  }

  override def updateObject(columnLabel: String, x: Any, scaleOrLength: Int): Unit = withExtraWork("updateObject", (columnLabel, x, scaleOrLength)) { case (columnLabel, x, scaleOrLength) =>
    resultSet.updateObject(columnLabel, x, scaleOrLength)
  }

  override def updateObject(columnLabel: String, x: Any): Unit = withExtraWork("updateObject", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateObject(columnLabel, x)
  }

  override def insertRow(): Unit = withExtraWork("insertRow") { _ =>
    resultSet.insertRow()
  }

  override def updateRow(): Unit = withExtraWork("updateRow") { _ =>
    resultSet.updateRow()
  }

  override def deleteRow(): Unit = withExtraWork("deleteRow") { _ =>
    resultSet.deleteRow()
  }

  override def refreshRow(): Unit = withExtraWork("refreshRow") { _ =>
    resultSet.refreshRow()
  }

  override def cancelRowUpdates(): Unit = withExtraWork("cancelRowUpdates") { _ =>
    resultSet.cancelRowUpdates()
  }

  override def moveToInsertRow(): Unit = withExtraWork("moveToInsertRow") { _ =>
    resultSet.moveToInsertRow()
  }

  override def moveToCurrentRow(): Unit = withExtraWork("moveToCurrentRow") { _ =>
    resultSet.moveToCurrentRow()
  }

  override def getStatement: Statement = withExtraWork("getStatement") { _ =>
    statement
  }

  override def getObject(columnIndex: Int, map: util.Map[String, Class[_]]): AnyRef = withExtraWork("getObject", (columnIndex, map)) { case (columnIndex, map) =>
    resultSet.getObject(columnIndex, map)
  }

  override def getRef(columnIndex: Int): Ref = withExtraWork("getRef", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getRef(columnIndex)
  }

  override def getBlob(columnIndex: Int): Blob = withExtraWork("getBlob", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getBlob(columnIndex)
  }

  override def getClob(columnIndex: Int): Clob = withExtraWork("getClob", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getClob(columnIndex)
  }

  override def getArray(columnIndex: Int): java.sql.Array = withExtraWork("getArray", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getArray(columnIndex)
  }

  override def getObject(columnLabel: String, map: util.Map[String, Class[_]]): AnyRef = withExtraWork("getObject", (columnLabel, map)) { case (columnLabel, map) =>
    resultSet.getObject(columnLabel, map)
  }

  override def getRef(columnLabel: String): Ref = withExtraWork("getRef", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getRef(columnLabel)
  }

  override def getBlob(columnLabel: String): Blob = withExtraWork("getBlob", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getBlob(columnLabel)
  }

  override def getClob(columnLabel: String): Clob = withExtraWork("getClob", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getClob(columnLabel)
  }

  override def getArray(columnLabel: String): java.sql.Array = withExtraWork("getArray", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getArray(columnLabel)
  }

  override def getDate(columnIndex: Int, cal: Calendar): Date = withExtraWork("getDate", (columnIndex, cal)) { case (columnIndex, cal) =>
    resultSet.getDate(columnIndex, cal)
  }

  override def getDate(columnLabel: String, cal: Calendar): Date = withExtraWork("getDate", (columnLabel, cal)) { case (columnLabel, cal) =>
    resultSet.getDate(columnLabel, cal)
  }

  override def getTime(columnIndex: Int, cal: Calendar): Time = withExtraWork("getTime", (columnIndex, cal)) { case (columnIndex, cal) =>
    resultSet.getTime(columnIndex, cal)
  }

  override def getTime(columnLabel: String, cal: Calendar): Time = withExtraWork("getTime", (columnLabel, cal)) { case (columnLabel, cal) =>
    resultSet.getTime(columnLabel, cal)
  }

  override def getTimestamp(columnIndex: Int, cal: Calendar): Timestamp = withExtraWork("getTimestamp", (columnIndex, cal)) { case (columnIndex, cal) =>
    resultSet.getTimestamp(columnIndex, cal)
  }

  override def getTimestamp(columnLabel: String, cal: Calendar): Timestamp = withExtraWork("getTimestamp", (columnLabel, cal)) { case (columnLabel, cal) =>
    resultSet.getTimestamp(columnLabel, cal)
  }

  override def getURL(columnIndex: Int): URL = withExtraWork("getURL", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getURL(columnIndex)
  }

  override def getURL(columnLabel: String): URL = withExtraWork("getURL", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getURL(columnLabel)
  }

  override def updateRef(columnIndex: Int, x: Ref): Unit = withExtraWork("updateRef", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateRef(columnIndex, x)
  }

  override def updateRef(columnLabel: String, x: Ref): Unit = withExtraWork("updateRef", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateRef(columnLabel, x)
  }

  override def updateBlob(columnIndex: Int, x: Blob): Unit = withExtraWork("updateBlob", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateBlob(columnIndex, x)
  }

  override def updateBlob(columnLabel: String, x: Blob): Unit = withExtraWork("updateBlob", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateBlob(columnLabel, x)
  }

  override def updateClob(columnIndex: Int, x: Clob): Unit = withExtraWork("updateClob", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateClob(columnIndex, x)
  }

  override def updateClob(columnLabel: String, x: Clob): Unit = withExtraWork("updateClob", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateClob(columnLabel, x)
  }

  override def updateArray(columnIndex: Int, x: java.sql.Array): Unit = withExtraWork("updateArray", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateArray(columnIndex, x)
  }

  override def updateArray(columnLabel: String, x: java.sql.Array): Unit = withExtraWork("updateArray", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateArray(columnLabel, x)
  }

  override def getRowId(columnIndex: Int): RowId = withExtraWork("getRowId", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getRowId(columnIndex)
  }

  override def getRowId(columnLabel: String): RowId = withExtraWork("getRowId", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getRowId(columnLabel)
  }

  override def updateRowId(columnIndex: Int, x: RowId): Unit = withExtraWork("updateRowId", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateRowId(columnIndex, x)
  }

  override def updateRowId(columnLabel: String, x: RowId): Unit = withExtraWork("updateRowId", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateRowId(columnLabel, x)
  }

  override def getHoldability: Int = withExtraWork("getHoldability") { _ =>
    resultSet.getHoldability
  }

  override def isClosed: Boolean = withExtraWork("isClosed") { _ =>
    resultSet.isClosed
  }

  override def updateNString(columnIndex: Int, nString: String): Unit = withExtraWork("updateNString", (columnIndex, nString)) { case (columnIndex, nString) =>
    resultSet.updateNString(columnIndex, nString)
  }

  override def updateNString(columnLabel: String, nString: String): Unit = withExtraWork("updateNString", (columnLabel, nString)) { case (columnLabel, nString) =>
    resultSet.updateNString(columnLabel, nString)
  }

  override def updateNClob(columnIndex: Int, nClob: NClob): Unit = withExtraWork("updateNClob", (columnIndex, nClob)) { case (columnIndex, nClob) =>
    resultSet.updateNClob(columnIndex, nClob)
  }

  override def updateNClob(columnLabel: String, nClob: NClob): Unit = withExtraWork("updateNClob", (columnLabel, nClob)) { case (columnLabel, nClob) =>
    resultSet.updateNClob(columnLabel, nClob)
  }

  override def getNClob(columnIndex: Int): NClob = withExtraWork("getNClob", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getNClob(columnIndex)
  }

  override def getNClob(columnLabel: String): NClob = withExtraWork("getNClob", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getNClob(columnLabel)
  }

  override def getSQLXML(columnIndex: Int): SQLXML = withExtraWork("getSQLXML", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getSQLXML(columnIndex)
  }

  override def getSQLXML(columnLabel: String): SQLXML = withExtraWork("getSQLXML", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getSQLXML(columnLabel)
  }

  override def updateSQLXML(columnIndex: Int, xmlObject: SQLXML): Unit = withExtraWork("updateSQLXML", (columnIndex, xmlObject)) { case (columnIndex, xmlObject) =>
    resultSet.updateSQLXML(columnIndex, xmlObject)
  }

  override def updateSQLXML(columnLabel: String, xmlObject: SQLXML): Unit = withExtraWork("updateSQLXML", (columnLabel, xmlObject)) { case (columnLabel, xmlObject) =>
    resultSet.updateSQLXML(columnLabel, xmlObject)
  }

  override def getNString(columnIndex: Int): String = withExtraWork("getNString", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getNString(columnIndex)
  }

  override def getNString(columnLabel: String): String = withExtraWork("getNString", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getNString(columnLabel)
  }

  override def getNCharacterStream(columnIndex: Int): Reader = withExtraWork("getNCharacterStream", Tuple1(columnIndex)) { case Tuple1(columnIndex) =>
    resultSet.getNCharacterStream(columnIndex)
  }

  override def getNCharacterStream(columnLabel: String): Reader = withExtraWork("getNCharacterStream", Tuple1(columnLabel)) { case Tuple1(columnLabel) =>
    resultSet.getNCharacterStream(columnLabel)
  }

  override def updateNCharacterStream(columnIndex: Int, x: Reader, length: Long): Unit = withExtraWork("updateNCharacterStream", (columnIndex, x, length)) { case (columnIndex, x, length) =>
    resultSet.updateNCharacterStream(columnIndex, x, length)
  }

  override def updateNCharacterStream(columnLabel: String, reader: Reader, length: Long): Unit = withExtraWork("updateNCharacterStream", (columnLabel, reader, length)) { case (columnLabel, reader, length) =>
    resultSet.updateNCharacterStream(columnLabel, reader, length)
  }

  override def updateAsciiStream(columnIndex: Int, x: InputStream, length: Long): Unit = withExtraWork("updateAsciiStream", (columnIndex, x, length)) { case (columnIndex, x, length) =>
    resultSet.updateAsciiStream(columnIndex, x, length)
  }

  override def updateBinaryStream(columnIndex: Int, x: InputStream, length: Long): Unit = withExtraWork("updateBinaryStream", (columnIndex, x, length)) { case (columnIndex, x, length) =>
    resultSet.updateBinaryStream(columnIndex, x, length)
  }

  override def updateCharacterStream(columnIndex: Int, x: Reader, length: Long): Unit = withExtraWork("updateCharacterStream", (columnIndex, x, length)) { case (columnIndex, x, length) =>
    resultSet.updateCharacterStream(columnIndex, x, length)
  }

  override def updateAsciiStream(columnLabel: String, x: InputStream, length: Long): Unit = withExtraWork("updateAsciiStream", (columnLabel, x, length)) { case (columnLabel, x, length) =>
    resultSet.updateAsciiStream(columnLabel, x, length)
  }

  override def updateBinaryStream(columnLabel: String, x: InputStream, length: Long): Unit = withExtraWork("updateBinaryStream", (columnLabel, x, length)) { case (columnLabel, x, length) =>
    resultSet.updateBinaryStream(columnLabel, x, length)
  }

  override def updateCharacterStream(columnLabel: String, reader: Reader, length: Long): Unit = withExtraWork("updateCharacterStream", (columnLabel, reader, length)) { case (columnLabel, reader, length) =>
    resultSet.updateCharacterStream(columnLabel, reader, length)
  }

  override def updateBlob(columnIndex: Int, inputStream: InputStream, length: Long): Unit = withExtraWork("updateBlob", (columnIndex, inputStream, length)) { case (columnIndex, inputStream, length) =>
    resultSet.updateBlob(columnIndex, inputStream, length)
  }

  override def updateBlob(columnLabel: String, inputStream: InputStream, length: Long): Unit = withExtraWork("updateBlob", (columnLabel, inputStream, length)) { case (columnLabel, inputStream, length) =>
    resultSet.updateBlob(columnLabel, inputStream, length)
  }

  override def updateClob(columnIndex: Int, reader: Reader, length: Long): Unit = withExtraWork("updateClob", (columnIndex, reader, length)) { case (columnIndex, reader, length) =>
    resultSet.updateClob(columnIndex, reader, length)
  }

  override def updateClob(columnLabel: String, reader: Reader, length: Long): Unit = withExtraWork("updateClob", (columnLabel, reader, length)) { case (columnLabel, reader, length) =>
    resultSet.updateClob(columnLabel, reader, length)
  }

  override def updateNClob(columnIndex: Int, reader: Reader, length: Long): Unit = withExtraWork("updateNClob", (columnIndex, reader, length)) { case (columnIndex, reader, length) =>
    resultSet.updateNClob(columnIndex, reader, length)
  }

  override def updateNClob(columnLabel: String, reader: Reader, length: Long): Unit = withExtraWork("updateNClob", (columnLabel, reader, length)) { case (columnLabel, reader, length) =>
    resultSet.updateNClob(columnLabel, reader, length)
  }

  override def updateNCharacterStream(columnIndex: Int, x: Reader): Unit = withExtraWork("updateNCharacterStream", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateNCharacterStream(columnIndex, x)
  }

  override def updateNCharacterStream(columnLabel: String, reader: Reader): Unit = withExtraWork("updateNCharacterStream", (columnLabel, reader)) { case (columnLabel, reader) =>
    resultSet.updateNCharacterStream(columnLabel, reader)
  }

  override def updateAsciiStream(columnIndex: Int, x: InputStream): Unit = withExtraWork("updateAsciiStream", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateAsciiStream(columnIndex, x)
  }

  override def updateBinaryStream(columnIndex: Int, x: InputStream): Unit = withExtraWork("updateBinaryStream", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateBinaryStream(columnIndex, x)
  }

  override def updateCharacterStream(columnIndex: Int, x: Reader): Unit = withExtraWork("updateCharacterStream", (columnIndex, x)) { case (columnIndex, x) =>
    resultSet.updateCharacterStream(columnIndex, x)
  }

  override def updateAsciiStream(columnLabel: String, x: InputStream): Unit = withExtraWork("updateAsciiStream", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateAsciiStream(columnLabel, x)
  }

  override def updateBinaryStream(columnLabel: String, x: InputStream): Unit = withExtraWork("updateBinaryStream", (columnLabel, x)) { case (columnLabel, x) =>
    resultSet.updateBinaryStream(columnLabel, x)
  }

  override def updateCharacterStream(columnLabel: String, reader: Reader): Unit = withExtraWork("updateCharacterStream", (columnLabel, reader)) { case (columnLabel, reader) =>
    resultSet.updateCharacterStream(columnLabel, reader)
  }

  override def updateBlob(columnIndex: Int, inputStream: InputStream): Unit = withExtraWork("updateBlob", (columnIndex, inputStream)) { case (columnIndex, inputStream) =>
    resultSet.updateBlob(columnIndex, inputStream)
  }

  override def updateBlob(columnLabel: String, inputStream: InputStream): Unit = withExtraWork("updateBlob", (columnLabel, inputStream)) { case (columnLabel, inputStream) =>
    resultSet.updateBlob(columnLabel, inputStream)
  }

  override def updateClob(columnIndex: Int, reader: Reader): Unit = withExtraWork("updateClob", (columnIndex, reader)) { case (columnIndex, reader) =>
    resultSet.updateClob(columnIndex, reader)
  }

  override def updateClob(columnLabel: String, reader: Reader): Unit = withExtraWork("updateClob", (columnLabel, reader)) { case (columnLabel, reader) =>
    resultSet.updateClob(columnLabel, reader)
  }

  override def updateNClob(columnIndex: Int, reader: Reader): Unit = withExtraWork("updateNClob", (columnIndex, reader)) { case (columnIndex, reader) =>
    updateNClob(columnIndex, reader)
  }

  override def updateNClob(columnLabel: String, reader: Reader): Unit = withExtraWork("updateNClob", (columnLabel, reader)) { case (columnLabel, reader) =>
    updateNClob(columnLabel, reader)
  }

  override def getObject[T](columnIndex: Int, `type`: Class[T]): T = withExtraWork("getObject", (columnIndex, `type`)) { case (columnIndex, typ) =>
    resultSet.getObject[T](columnIndex, typ)
  }

  override def getObject[T](columnLabel: String, `type`: Class[T]): T = withExtraWork("getObject", (columnLabel, `type`)) { case (columnLabel, typ) =>
    resultSet.getObject[T](columnLabel, typ)
  }

  override def unwrap[T](iface: Class[T]): T = withExtraWork("unwrap", Tuple1(iface)) { case Tuple1(iface) =>
    resultSet.unwrap[T](iface)
  }

  override def isWrapperFor(iface: Class[_]): Boolean = withExtraWork("isWrapperFor", Tuple1(iface)) { case Tuple1(iface) =>
    resultSet.isWrapperFor(iface)
  }
}
