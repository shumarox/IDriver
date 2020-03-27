package test.ice.jdbc

import java.sql.{Array => _, _}
import java.util.Properties
import java.util.logging.Logger

object DDriver {
  DriverManager.registerDriver(new DDriver)
}

class DDriver extends Driver {

  override def connect(url: String, info: Properties): Connection = {
    if (!url.startsWith("jdbc:test:")) null else new DConnection(url, info)
  }

  override def acceptsURL(url: String): Boolean = ???

  override def getPropertyInfo(url: String, info: Properties): Array[DriverPropertyInfo] = ???

  override def getMajorVersion: Int = ???

  override def getMinorVersion: Int = ???

  override def jdbcCompliant: Boolean = ???

  override def getParentLogger: Logger = ???
}

