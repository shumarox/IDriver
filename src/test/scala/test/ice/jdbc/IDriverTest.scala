package test.ice.jdbc

import java.io.{BufferedWriter, FileWriter}
import java.sql.DriverManager
import java.util.Properties

import ice.jdbc.{IDriver, IExtraWorkerHandler, StandardLogWorker}
import org.junit.Test

import scala.util.Using
import scala.util.matching.Regex

class IDriverTest {

  @Test
  def test(): Unit = {
    // テストを同時実行させないための同期化
    IExtraWorkerHandler.synchronized {
      Using.resource(new BufferedWriter(new FileWriter("./IDriverTest.log", true))) { writer =>
        // 標準ログワーカーをカスタマイズして登録
        IExtraWorkerHandler.extraWorker = new StandardLogWorker {
          private val skipClassNameRegex: Regex = """^(java\.|scala\.|ice\.jdbc\.).*""".r

          override def isSkipClassName(s: String): Boolean = skipClassNameRegex.matches(s)

          override def write(s: String): Unit = {
            writer.write(s + "\n")
            writer.flush()
          }
        }

        // IDriverの登録（テストを繰り返し実行する場合に必要）
        // ※META-INF/java.sql.Driverに記載しているため不要
        new IDriver()

        Class.forName("test.ice.jdbc.DDriver$")

        val url = "i!jdbc:test://testhost/testdb"
        val props = new Properties {
          setProperty("user", "test_user")
          setProperty("password", "himitsu")
        }

        Using.resource(DriverManager.getConnection(url, props)) { con =>
          con.setAutoCommit(false)

          Using.resource(con.prepareStatement("SELECT * FROM TEST\nWHERE X IN (?, ?)")) { ps =>
            ps.setString(1, "foo")
            ps.setString(2, "var")

            Using.resource(ps.executeQuery()) { rs =>
              while (rs.next()) println("result: " + (rs.getString(1), rs.getString(2)))
            }
          }

          con.commit();
        }
      }
    }
  }
}
