package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}




