package ice.jdbc

import java.sql.{Array => _, _}

class IStatement(val connection: IConnection, val statement: Statement) extends Statement with IExtraWorkerHandler {

  override def toString: String = s"(i!)${statement.toString}"

  override def execute(sql: String): Boolean = withExtraWork("execute", Tuple1(sql)) { case Tuple1(sql) => statement.execute(sql) }
  override def executeQuery(sql: String): ResultSet = withExtraWork("executeQuery", Tuple1(sql)) { case Tuple1(sql) => new IResultSet(this, statement.executeQuery(sql)) }
  override def close(): Unit = withExtraWork("close") { _ => statement.close() }
  override def executeUpdate(sql: String): Int = withExtraWork("executeUpdate", Tuple1(sql)) { case Tuple1(sql) => statement.executeUpdate(sql) }
  override def getMaxFieldSize: Int = withExtraWork("getMaxFieldSize") { _ => statement.getMaxFieldSize }
  override def setMaxFieldSize(max: Int): Unit = withExtraWork("setMaxFieldSize", Tuple1(max)) { case Tuple1(max) => statement.setMaxFieldSize(max) }
  override def getMaxRows: Int = withExtraWork("getMaxRows") { _ => statement.getMaxRows }
  override def setMaxRows(max: Int): Unit = withExtraWork("setMaxRows", Tuple1(max)) { case Tuple1(max) => statement.setMaxRows(max) }
  override def setEscapeProcessing(enable: Boolean): Unit = withExtraWork("setEscapeProcessing", Tuple1(enable)) { case Tuple1(enable) => statement.setEscapeProcessing(enable) }
  override def getQueryTimeout: Int = withExtraWork("getQueryTimeout") { _ => statement.getQueryTimeout }
  override def setQueryTimeout(seconds: Int): Unit = withExtraWork("setQueryTimeout", Tuple1(seconds)) { case Tuple1(seconds) => statement.setQueryTimeout(seconds) }
  override def cancel(): Unit = withExtraWork("cancel") { _ => statement.cancel() }
  override def getWarnings: SQLWarning = withExtraWork("getWarnings") { _ => statement.getWarnings }
  override def clearWarnings(): Unit = withExtraWork("clearWarnings") { _ => statement.clearWarnings }
  override def setCursorName(name: String): Unit = withExtraWork("setCursorName", Tuple1(name)) { case Tuple1(name) => statement.setCursorName(name) }
  override def getResultSet: ResultSet = withExtraWork("getResultSet") { _ => new IResultSet(this, statement.getResultSet) }
  override def getUpdateCount: Int = withExtraWork("getUpdateCount") { _ => statement.getUpdateCount }
  override def getMoreResults: Boolean = withExtraWork("getMoreResults") { _ => statement.getMoreResults }
  override def setFetchDirection(direction: Int): Unit = withExtraWork("setFetchDirection", Tuple1(direction)) { case Tuple1(direction) => statement.setFetchDirection(direction) }
  override def getFetchDirection: Int = withExtraWork("getFetchDirection") { _ => statement.getFetchDirection }
  override def setFetchSize(rows: Int): Unit = withExtraWork("setFetchSize", Tuple1(rows)) { case Tuple1(rows) => statement.setFetchSize(rows) }
  override def getFetchSize: Int = withExtraWork("getFetchSize") { _ => statement.getFetchSize }
  override def getResultSetConcurrency: Int = withExtraWork("getResultSetConcurrency") { _ => statement.getResultSetConcurrency }
  override def getResultSetType: Int = withExtraWork("getResultSetType") { _ => statement.getResultSetType }
  override def addBatch(sql: String): Unit = withExtraWork("addBatch", Tuple1(sql)) { case Tuple1(sql) => statement.addBatch(sql) }
  override def clearBatch(): Unit = withExtraWork("clearBatch") { _ => statement.clearBatch() }
  override def executeBatch(): Array[Int] = withExtraWork("executeBatch") { _ => statement.executeBatch() }
  override def getConnection: Connection = withExtraWork("getConnection") { _ => connection }
  override def getMoreResults(current: Int): Boolean = withExtraWork("getMoreResults", Tuple1(current)) { case Tuple1(current) => statement.getMoreResults(current) }
  override def getGeneratedKeys: ResultSet = withExtraWork("getGeneratedKeys") { _ => new IResultSet(this, statement.getGeneratedKeys) }
  override def executeUpdate(sql: String, autoGeneratedKeys: Int): Int = withExtraWork("executeUpdate", (sql, autoGeneratedKeys)) { case (sql, autoGeneratedKeys) => statement.executeUpdate(sql, autoGeneratedKeys) }
  override def executeUpdate(sql: String, columnIndexes: Array[Int]): Int = withExtraWork("executeUpdate", (sql, columnIndexes)) { case (sql, columnIndexes) => statement.executeUpdate(sql, columnIndexes) }
  override def executeUpdate(sql: String, columnNames: Array[String]): Int = withExtraWork("executeUpdate", (sql, columnNames)) { case (sql, columnNames) => statement.executeUpdate(sql, columnNames) }
  override def execute(sql: String, autoGeneratedKeys: Int): Boolean = withExtraWork("execute", (sql, autoGeneratedKeys)) { case (sql, autoGeneratedKeys) => statement.execute(sql, autoGeneratedKeys) }
  override def execute(sql: String, columnIndexes: Array[Int]): Boolean = withExtraWork("execute", (sql, columnIndexes)) { case (sql, columnIndexes) => statement.execute(sql, columnIndexes) }
  override def execute(sql: String, columnNames: Array[String]): Boolean = withExtraWork("execute", (sql, columnNames)) { case (sql, columnNames) => statement.execute(sql, columnNames) }
  override def getResultSetHoldability: Int = withExtraWork("getResultSetHoldability") { _ => statement.getResultSetHoldability }
  override def isClosed: Boolean = withExtraWork("isClosed") { _ => statement.isClosed }
  override def setPoolable(poolable: Boolean): Unit = withExtraWork("setPoolable", Tuple1(poolable)) { case Tuple1(poolable) => statement.setPoolable(poolable) }
  override def isPoolable: Boolean = withExtraWork("isPoolable") { _ => statement.isPoolable }
  override def closeOnCompletion(): Unit = withExtraWork("closeOnCompletion") { _ => statement.closeOnCompletion() }
  override def isCloseOnCompletion: Boolean = withExtraWork("isCloseOnCompletion") { _ => statement.isCloseOnCompletion }
  override def unwrap[T](ifase: Class[T]): T = withExtraWork("unwrap", Tuple1(ifase)) { case Tuple1(ifase) => statement.unwrap[T](ifase) }
  override def isWrapperFor(ifase: Class[_]): Boolean = withExtraWork("isWrapperFor", Tuple1(ifase)) { case Tuple1(ifase) => statement.isWrapperFor(ifase) }
}
