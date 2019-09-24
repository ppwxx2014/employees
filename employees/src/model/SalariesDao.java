package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelp;

public class SalariesDao {
	// salaries테이블의 총 갯수
	public int selectSalariesCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) cnt FROM salaries";
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
