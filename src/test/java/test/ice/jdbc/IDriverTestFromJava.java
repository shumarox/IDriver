package test.ice.jdbc;

import ice.jdbc.IDriver;
import ice.jdbc.IExtraWorkerHandler;
import ice.jdbc.IExtraWorkerHandler$;
import ice.jdbc.StandardLogWorker;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.regex.Pattern;

public class IDriverTestFromJava {

    @Test
    public void test() throws Exception {
        // テストを同時実行させないための同期化
        synchronized(IExtraWorkerHandler$.MODULE$) {
            try (Writer writer = new BufferedWriter(new FileWriter("./IDriverTest.log", true))) {
                // 標準ログワーカーをカスタマイズして登録
                IExtraWorkerHandler.setExtraWorker(new StandardLogWorker() {
                    Pattern pattern = Pattern.compile("^(java\\.|scala\\.|ice\\.jdbc\\.).*");

                    @Override
                    public boolean isSkipClassName(String s) {
                        return pattern.matcher(s).find();
                    }

                    @Override
                    public void write(String s) throws IOException {
                        writer.write(s + "\n");
                        writer.flush();
                    }
                });

                // IDriverの登録（テストを繰り返し実行する場合に必要）
                // ※META-INF/java.sql.Driverに記載しているため不要
                new IDriver();

                Class.forName("test.ice.jdbc.DDriver$");

                String url = "i!jdbc:test://testhost/testdb";

                Properties props = new Properties();
                props.setProperty("user", "test_user");
                props.setProperty("password", "himitsu");

                try (Connection con = DriverManager.getConnection(url, props)) {
                    try (PreparedStatement ps = con.prepareStatement("SELECT * FROM TEST\nWHERE X IN (?, ?)")) {
                        ps.setString(1, "foo");
                        ps.setString(2, "var");

                        try (ResultSet rs = ps.executeQuery()) {
                            while (rs.next()) {
                                System.out.println(String.format("result: (%s, %s)", rs.getString(1), rs.getString(2)));
                            }
                        }

                        con.commit();
                    }
                }
            }
        }
    }
}
