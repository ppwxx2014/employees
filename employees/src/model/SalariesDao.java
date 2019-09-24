package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

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
	
	// 통계함수를 보여주는 메서드
	public Map<String, Long> selectSalariesStatistics() {
		// Map은 <>사이 참조변수가 들어가야 함으로 long대신 Long사용
		Map<String, Long> map = new HashMap<String, Long>();
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT COUNT(salary), SUM(salary), AVG(salary), MAX(salary), MIN(salary), STD(salary) FROM salaries";
	    try {
	    	// static 메서드라서 바로 호출 가능
	    	DBHelp.getConncetion();
	    	stmt = conn.prepareStatement(sql);
	    	rs = stmt.executeQuery();
	    	while(rs.next()) {
	    		// map 타입은 ("키값","밸류값")
	    		map.put("count", rs.getLong("COUNT(salary)"));
	    		map.put("sum", rs.getLong("SUM(salary)"));
	    		map.put("avg", rs.getLong("AVG(salary)"));
	    		map.put("max", rs.getLong("MAX(salary)"));
	    		map.put("min", rs.getLong("MIN(salary)"));
	    		map.put("std", rs.getLong("STD(salary)")); // 표준편차
	    	}
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	DBHelp.close(rs, stmt, conn);
	    }
	    return map;
	}
}






