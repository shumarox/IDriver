# i!Driver
JDBC Driver Wrapper

#### 用途
JDBC呼び出し前後に割り込んで、引数/戻り値改変やログ出力などが行えるようにJDBCドライバをラップ

#### 標準動作
SQLなどを標準出力へ出力する。

#### 利用方法
JDBC接続URLの先頭に"i!"を付加

#### 出力例
```pl
2020/03/28 01:46:21.862 ice.jdbc.IDriver@4c15e7fd.connect(i!jdbc:test://testhost/testdb,{user=test_user, password=*}) returned: (i!)test.ice.jdbc.DConnection@49c386c8 time: 0.007 from: test.ice.jdbc.IDriverTestFromJava.test(IDriverTestFromJava.java:55)
2020/03/28 01:46:21.920 (i!)test.ice.jdbc.DConnection@49c386c8.prepareStatement(SELECT * FROM TEST	WHERE X IN (?, ?)) returned: (i!)test.ice.jdbc.DPreparedStatement@6379eb time: 0.026 from: test.ice.jdbc.IDriverTestFromJava.test(IDriverTestFromJava.java:56)
2020/03/28 01:46:21.930 (i!)test.ice.jdbc.DPreparedStatement@6379eb.executeQuery() returned: (i!)test.ice.jdbc.DResultSet@399f45b1 time: 0.005 from: test.ice.jdbc.IDriverTestFromJava.test(IDriverTestFromJava.java:60) binds: {foo	var} bindClasses: {java.lang.String	java.lang.String} sql: {SELECT * FROM TEST	WHERE X IN ('foo', 'var')}
2020/03/28 01:46:21.943 (i!)test.ice.jdbc.DConnection@49c386c8.commit() returned time: 0.000 from: test.ice.jdbc.IDriverTestFromJava.test(IDriverTestFromJava.java:66)
2020/03/28 01:46:21.945 (i!)test.ice.jdbc.DConnection@49c386c8.close() returned time: 0.000 from: test.ice.jdbc.IDriverTestFromJava.test(IDriverTestFromJava.java:68)
```

#### 使用例
https://github.com/shumarox/IDriver/blob/master/src/test/java/test/ice/jdbc/IDriverTestFromJava.java
