package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelp;
import vo.Department;

public class DepartmentsDao {
	
	// departments테이블의 리스트를 보여주는 메소드
	public List<Department> selectDepartmentsList() {
		
		List<Department> list = new ArrayList<Department>(); // 다형성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT dept_no, dept_name FROM departments";
		
		// try-catch로 예외처리
		try {
			conn = DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Department department = new Department();
				department.setDeptNo(rs.getString("dept_no"));
				department.setDeptName(rs.getString("dept_name"));
				list.add(department);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelp.close(rs, stmt, conn);
		}
		return list;
	}
	
	public int selectDepartmentsCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) cnt FROM departments";
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
	
		//group by having 이용 부서별 인원수 구하기
		public List<Map<String, Object>> selectDepartmentsCountByDeptNo() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//dep_emp,departments join,dept group by 
		String sql = "SELECT de.dept_no, d.dept_name, COUNT(d.dept_no) AS cnt FROM departments d INNER JOIN dept_emp de ON d.dept_no = de.dept_no GROUP BY d.dept_no ORDER BY dept_no";
			try {
				conn = DBHelp.getConncetion();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				 while(rs.next()) {
					 Map<String, Object> map = new HashMap<String, Object>();
					 map.put("deptNo", rs.getString("de.dept_no"));
					 map.put("deptName", rs.getString("d.dept_name"));
					 map.put("cnt", rs.getInt("cnt"));
					 list.add(map);
				 }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBHelp.close(rs, stmt, conn);
			}

		return list;
	}
}




