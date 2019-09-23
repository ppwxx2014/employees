package model;

import java.sql.*;

import vo.DBHelp;

public class DeptEmpDao {
	// deptEmp테이블의 전체 행의 갯수를 구하는 메소드
		public int selectDeptEmpCount() {
			int count = 0;
			final String sql = "SELECT COUNT(*) cnt FROM dept_emp";
			String url = "jdbc:mariadb://127.0.0.1:3306/employees";
			String dbUser = "root";
			String dbPw = "java1234";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
		      try {
		    	  DBHelp dbHelp = new DBHelp();
					conn = dbHelp.getConnection(url,dbUser,dbPw);
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					if(rs.next()) {
						count = rs.getInt("cnt");
					}
		      }catch(Exception e) {
		         e.printStackTrace();
		      } finally {
		         //반납
		         try {
		            rs.close();
		            stmt.close();
		            conn.close();
		         }catch(Exception e) {
		            // 반납하다 예외 발생시 예외 콘솔창에 출력
		            e.printStackTrace();
		         }
		      }
		      return count;
		   }
}
