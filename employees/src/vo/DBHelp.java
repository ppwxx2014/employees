package vo;

import java.sql.*;

// DB연결을 도와주는 메소드
public class DBHelp {
	public Connection getConnection(String dirver, String dbId, String dbPw) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = null;
		
		conn = DriverManager.getConnection(dirver, dbId, dbPw);
		return conn;
	}
}
