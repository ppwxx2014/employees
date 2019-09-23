package model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.DBHelp;
import vo.Department;
import vo.Employees;

public class EmployeesDao {
	public int selectEmployeesCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) cnt FROM employees";
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
		} catch(Exception e) { // 자바의 생명주기 -> ()
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	// employees테이블의 내용을 가진 리스트를 입력한 갯수만큼 보여주는 메소드
	public List<Employees> selectEmployeesListByLimit(int limit) {
		System.out.println("보여줄 갯수 : " + limit);
		
		List<Employees> list = new ArrayList<Employees>(); // 다형성
		String url = "jdbc:mariadb://127.0.0.1:3306/employees";
		String dbUser = "root";
		String dbPw = "java1234";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?";
		
		// try-catch로 예외처리
		try {
			// db연결을 도와주는 메소드 호출
			DBHelp dbHelp = new DBHelp();
			conn = dbHelp.getConnection(url,dbUser,dbPw);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
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
	
	// 사원의 이름을 오름차순, 내림차순 보기
	public List<Employees> selectEmployeesListOrderBy(String order) {
		List<Employees> list = new ArrayList<Employees>(); // 다형성
		String url = "jdbc:mariadb://127.0.0.1:3306/employees";
		String dbUser = "root";
		String dbPw = "java1234";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		if(order.equals("asc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name, last_name ASC LIMIT 50";
		} else if(order.equals("desc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name, last_name DESC LIMIT 50";
		}
		// db연결을 도와주는 메소드 호출
		try {
			DBHelp dbHelp = new DBHelp();
			conn = dbHelp.getConnection(url,dbUser,dbPw);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
					Employees employees = new Employees();
					employees.setEmpNo(rs.getInt("emp_no"));
					employees.setBirthDate(rs.getString("birth_date"));
					employees.setFirstName(rs.getString("first_name"));
					employees.setLastName(rs.getString("last_name"));
					employees.setGender(rs.getString("gender"));
					employees.setHireDate(rs.getString("hire_date"));
					list.add(employees);
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














