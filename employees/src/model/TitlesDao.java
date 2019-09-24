package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelp;

public class TitlesDao {
	// titles테이블의 총 행의 갯수를 구하는 메소드
	public int selectTitlesCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) cnt FROM titles";
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
	
	// 중복을 제거한 직급 종류
	public List<String> selectTitlesListDistinct() {
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT DISTINCT title FROM titles";
		try {
			conn = DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//반납
	    	  DBHelp.close(rs, stmt, conn);
		}
		return list;
	}
}







