package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.DBHelp;
import vo.Department;

public class DepartmentsDao {
	
	// departments테이블의 리스트를 보여주는 메소드
	public List<Department> selectDepartmentsList() {
		
		List<Department> list = new ArrayList<Department>(); // 다형성
		String url = "jdbc:mariadb://127.0.0.1:3306/employees";
		String dbUser = "root";
		String dbPw = "java1234";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT dept_no, dept_name FROM departments";
		
		// try-catch로 예외처리
		try {
			DBHelp dbHelp = new DBHelp();
			conn = dbHelp.getConnection(url,dbUser,dbPw);
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
			try { // 메모리 낭비를 막기 위해 사용 종료
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}




