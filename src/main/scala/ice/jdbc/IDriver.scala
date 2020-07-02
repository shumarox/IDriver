package ice.jdbc

import java.sql.{Array => _, _}
import java.util.Properties
import java.util.logging.Logger

private object IDriver {
  var connectionWrappingEnabled: Boolean = true

  private var initialized: Boolean = false
}

class IDriver extends Driver with IExtraWorkerHandler {

  import IDriver._

  def uriPrefix: String = "i!"

  def createWrappedConnection(unwrappedUrl: String, connection: Connection): Connection =
    if (connectionWrappingEnabled) new IConnection(this, unwrappedUrl, connection) else connection

  if (!initialized) {
    DriverManager.registerDriver(this)
    initialized = true
  }

  override def connect(url: String, info: Properties): Connection = withExtraWork("connect", (url, info)) { case (url, info) =>
    if (url.startsWith(uriPrefix)) {
      val unwrappedUrl = url.drop(uriPrefix.length)
      createWrappedConnection(unwrappedUrl, DriverManager.getConnection(unwrappedUrl, info))
    } else {
      null
    }
  }

  override def acceptsURL(url: String): Boolean = withExtraWork("acceptsURL", Tuple1(url)) { case Tuple1(url) =>
    url.startsWith(uriPrefix)
  }

  override def getPropertyInfo(url: String, info: Properties): Array[DriverPropertyInfo] = withExtraWork("getPropertyInfo", (url, info)) { case (url, info) =>
    val unwrappedUrl = url.drop(uriPrefix.length)
    DriverManager.getDriver(unwrappedUrl).getPropertyInfo(unwrappedUrl, info)
  }

  override def getMajorVersion: Int = withExtraWork("getMajorVersion")(_ => 0)

  override def getMinorVersion: Int = withExtraWork("getMinorVersion")(_ => 0)

  override def jdbcCompliant: Boolean = withExtraWork("jdbcCompliant")(_ => false)

  override def getParentLogger: Logger = withExtraWork("getParentLogger")(_ => null)
}

