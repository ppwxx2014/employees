package model;

import java.sql.*;

import db.DBHelp;

public class DeptEmpDao {
	// deptEmp테이블의 전체 행의 갯수를 구하는 메소드
		public int selectDeptEmpCount() {
			int count = 0;
			final String sql = "SELECT COUNT(*) cnt FROM dept_emp";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
		      try {
		    	  	conn = DBHelp.getConncetion();
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					if(rs.next()) {
						count = rs.getInt("cnt");
					}
		      }catch(Exception e) {
		         e.printStackTrace();
		      } finally {
		         //반납
		    	  DBHelp.close(rs, stmt, conn);
		      }
		      return count;
		   }
}
