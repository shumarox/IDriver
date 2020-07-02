package ice.jdbc

import java.sql.{Array => _, _}
import java.util
import java.util.Properties
import java.util.concurrent.Executor

object IConnection {
  var statementWrappingEnabled: Boolean = true
  var preparedStatementWrappingEnabled: Boolean = true
  var callableStatementWrappingEnabled: Boolean = true
}

class IConnection(val driver: IDriver, val unwrappedUrl: String, val connection: Connection) extends Connection with IExtraWorkerHandler {

  import IConnection._

  def createWrappedStatement(statement: Statement): Statement =
    if (statementWrappingEnabled) new IStatement(this, statement) else statement

  def createWrappedPreparedStatement(preparedStatement: PreparedStatement, sql: String): PreparedStatement =
    if (preparedStatementWrappingEnabled) new IPreparedStatement(this, preparedStatement, sql) else preparedStatement

  def createWrappedCallableStatement(callableStatement: CallableStatement, sql: String): CallableStatement =
    if (callableStatementWrappingEnabled) new ICallableStatement(this, callableStatement, sql) else callableStatement

  override def toString: String = s"(i!)${connection.toString}"

  override def close(): Unit = withExtraWork("close") { _ => connection.close() }
  override def createStatement(): Statement = withExtraWork("createStatement") { _ => createWrappedStatement(connection.createStatement()) }
  override def prepareStatement(sql: String): PreparedStatement = withExtraWork("prepareStatement", Tuple1(sql)) { case Tuple1(sql) => createWrappedPreparedStatement(connection.prepareStatement(sql), sql) }
  override def prepareCall(sql: String): CallableStatement = withExtraWork("prepareCall", Tuple1(sql)) { case Tuple1(sql) => createWrappedCallableStatement(connection.prepareCall(sql), sql) }
  override def nativeSQL(sql: String): String = withExtraWork("nativeSQL", Tuple1(sql)) { case Tuple1(sql) => connection.nativeSQL(sql) }
  override def setAutoCommit(autoCommit: Boolean): Unit = withExtraWork("setAutoCommit", Tuple1(autoCommit)) { case Tuple1(autoCommit) => connection.setAutoCommit(autoCommit) }
  override def getAutoCommit: Boolean = withExtraWork("getAutoCommit") { _ => connection.getAutoCommit }
  override def commit(): Unit = withExtraWork("commit") { _ => connection.commit() }
  override def rollback(): Unit = withExtraWork("rollback") { _ => connection.rollback() }
  override def isClosed: Boolean = withExtraWork("isClosed") { _ => connection.isClosed }
  override def getMetaData: DatabaseMetaData = withExtraWork("getMetaData") { _ => connection.getMetaData }
  override def setReadOnly(readOnly: Boolean): Unit = withExtraWork("setReadOnly", Tuple1(readOnly)) { case Tuple1(readOnly) => connection.setReadOnly(readOnly) }
  override def isReadOnly: Boolean = withExtraWork("isReadOnly") { _ => connection.isReadOnly }
  override def setCatalog(catalog: String): Unit = withExtraWork("setCatalog", Tuple1(catalog)) { case Tuple1(catalog) => connection.setCatalog(catalog) }
  override def getCatalog: String = withExtraWork("getCatalog") { _ => connection.getCatalog }
  override def setTransactionIsolation(level: Int): Unit = withExtraWork("setTransactionIsolation", Tuple1(level)) { case Tuple1(level) => connection.setTransactionIsolation(level) }
  override def getTransactionIsolation: Int = withExtraWork("getTransactionIsolation") { _ => connection.getTransactionIsolation }
  override def getWarnings: SQLWarning = withExtraWork("getWarnings") { _ => connection.getWarnings }
  override def clearWarnings(): Unit = withExtraWork("clearWarnings") { _ => connection.clearWarnings() }
  override def createStatement(resultSetType: Int, resultSetConcurrency: Int): Statement = withExtraWork("createStatement", (resultSetType, resultSetConcurrency)) { case (resultSetType, resultSetConcurrency) => createWrappedStatement(connection.createStatement(resultSetType, resultSetConcurrency)) }
  override def prepareStatement(sql: String, resultSetType: Int, resultSetConcurrency: Int): PreparedStatement = withExtraWork("prepareStatement", (sql, resultSetType, resultSetConcurrency)) { case (sql, resultSetType, resultSetConcurrency) => createWrappedPreparedStatement(connection.prepareStatement(sql, resultSetType, resultSetConcurrency), sql) }
  override def prepareCall(sql: String, resultSetType: Int, resultSetConcurrency: Int): CallableStatement = withExtraWork("prepareCall", (sql, resultSetType, resultSetConcurrency)) { case (sql, resultSetType, resultSetConcurrency) => createWrappedCallableStatement(connection.prepareCall(sql, resultSetType, resultSetConcurrency), sql) }
  override def getTypeMap: util.Map[String, Class[_]] = withExtraWork("getTypeMap") { _ => connection.getTypeMap }
  override def setTypeMap(map: util.Map[String, Class[_]]): Unit = withExtraWork("setTypeMap", Tuple1(map)) { case Tuple1(map) => connection.setTypeMap(map) }
  override def setHoldability(holdability: Int): Unit = withExtraWork("setHoldability", Tuple1(holdability)) { case Tuple1(holdability) => connection.setHoldability(holdability) }
  override def getHoldability: Int = withExtraWork("getHoldability") { _ => connection.getHoldability }
  override def setSavepoint(): Savepoint = withExtraWork("setSavepoint") { _ => connection.setSavepoint() }
  override def setSavepoint(name: String): Savepoint = withExtraWork("setSavepoint", Tuple1(name)) { case Tuple1(name) => connection.setSavepoint(name) }
  override def rollback(savepoint: Savepoint): Unit = withExtraWork("rollback", Tuple1(savepoint)) { case Tuple1(savepoint) => connection.rollback(savepoint) }
  override def releaseSavepoint(savepoint: Savepoint): Unit = withExtraWork("releaseSavepoint", Tuple1(savepoint)) { case Tuple1(savepoint) => connection.releaseSavepoint(savepoint) }
  override def createStatement(resultSetType: Int, resultSetConcurrency: Int, resultSetHoldability: Int): Statement = withExtraWork("createStatement", (resultSetType, resultSetConcurrency, resultSetHoldability)) { case (resultSetType, resultSetConcurrency, resultSetHoldability) => createWrappedStatement(connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability)) }
  override def prepareStatement(sql: String, resultSetType: Int, resultSetConcurrency: Int, resultSetHoldability: Int): PreparedStatement = withExtraWork("prepareStatement", (sql, resultSetType, resultSetConcurrency, resultSetHoldability)) { case (sql, resultSetType, resultSetConcurrency, resultSetHoldability) => createWrappedPreparedStatement(connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability), sql) }
  override def prepareCall(sql: String, resultSetType: Int, resultSetConcurrency: Int, resultSetHoldability: Int): CallableStatement = withExtraWork("prepareCall", (sql, resultSetType, resultSetConcurrency, resultSetHoldability)) { case (sql, resultSetType, resultSetConcurrency, resultSetHoldability) => createWrappedCallableStatement(connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability), sql) }
  override def prepareStatement(sql: String, autoGeneratedKeys: Int): PreparedStatement = withExtraWork("prepareStatement", (sql, autoGeneratedKeys)) { case (sql, autoGeneratedKeys) => createWrappedPreparedStatement(connection.prepareStatement(sql, autoGeneratedKeys), sql) }
  override def prepareStatement(sql: String, columnIndexes: Array[Int]): PreparedStatement = withExtraWork("prepareStatement", (sql, columnIndexes)) { case (sql, columnIndexes) => createWrappedPreparedStatement(connection.prepareStatement(sql, columnIndexes), sql) }
  override def prepareStatement(sql: String, columnNames: Array[String]): PreparedStatement = withExtraWork("prepareStatement", (sql, columnNames)) { case (sql, columnNames) => createWrappedPreparedStatement(connection.prepareStatement(sql, columnNames), sql) }
  override def createClob(): Clob = withExtraWork("createClob") { _ => connection.createClob() }
  override def createBlob(): Blob = withExtraWork("createBlob") { _ => connection.createBlob() }
  override def createNClob(): NClob = withExtraWork("createNClob") { _ => connection.createNClob() }
  override def createSQLXML(): SQLXML = withExtraWork("createSQLXML") { _ => connection.createSQLXML() }
  override def isValid(timeout: Int): Boolean = withExtraWork("isValid", Tuple1(timeout)) { case Tuple1(timeout) => connection.isValid(timeout) }
  override def setClientInfo(name: String, value: String): Unit = withExtraWork("setClientInfo", (name, value)) { case (name, value) => connection.setClientInfo(name, value) }
  override def setClientInfo(properties: Properties): Unit = withExtraWork("setClientInfo", Tuple1(properties)) { case Tuple1(properties) => connection.setClientInfo(properties) }
  override def getClientInfo(name: String): String = withExtraWork("getClientInfo", Tuple1(name)) { case Tuple1(name) => connection.getClientInfo(name) }
  override def getClientInfo: Properties = withExtraWork("getClientInfo") { _ => connection.getClientInfo }
  override def createArrayOf(typeName: String, elements: Array[AnyRef]): java.sql.Array = withExtraWork("createArrayOf", (typeName, elements)) { case (typeName, elements) => connection.createArrayOf(typeName, elements) }
  override def createStruct(typeName: String, attributes: Array[AnyRef]): Struct = withExtraWork("createStruct", (typeName, attributes)) { case (typeName, attributes) => connection.createStruct(typeName, attributes) }
  override def setSchema(schema: String): Unit = withExtraWork("setSchema", Tuple1(schema)) { case Tuple1(schema) => connection.setSchema(schema) }
  override def getSchema: String = withExtraWork("getSchema") { _ => connection.getSchema }
  override def abort(executor: Executor): Unit = withExtraWork("abort", Tuple1(executor)) { case Tuple1(executor) => connection.abort(executor) }
  override def setNetworkTimeout(executor: Executor, milliseconds: Int): Unit = withExtraWork("setNetworkTimeout", (executor, milliseconds)) { case (executor, milliseconds) => connection.setNetworkTimeout(executor, milliseconds) }
  override def getNetworkTimeout: Int = withExtraWork("getNetworkTimeout") { _ => connection.getNetworkTimeout }
  override def unwrap[T](iface: Class[T]): T = withExtraWork("unwrap", Tuple1(iface)) { case Tuple1(iface) => connection.unwrap[T](iface) }
  override def isWrapperFor(iface: Class[_]): Boolean = withExtraWork("isWrapperFor", Tuple1(iface)) { case Tuple1(iface) => connection.isWrapperFor(iface) }
}
