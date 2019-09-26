package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelp;
import vo.Employees;

public class EmployeesDao {
	// employees테이블의 총 갯수 
	public int selectEmployeesCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) cnt FROM employees";
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
		} catch(Exception e) { // 자바의 생명주기 -> ()
			e.printStackTrace();
		} finally {
			DBHelp.close(rs, stmt, conn);
		}
		return count;
	}
	
	// employees테이블의 내용을 가진 리스트를 입력한 갯수만큼 보여주는 메소드
	public List<Employees> selectEmployeesListByLimit(int limit) {
		System.out.println("보여줄 갯수 : " + limit);
		
		List<Employees> list = new ArrayList<Employees>(); // 다형성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?";
		
		// try-catch로 예외처리
		try {
			// db연결을 도와주는 메소드 호출
			conn = DBHelp.getConncetion();
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
			DBHelp.close(rs, stmt, conn);
		}
		return list;
	}
	
	// 사원의 이름을 오름차순, 내림차순 보기
	public List<Employees> selectEmployeesListOrderBy(String order) {
		List<Employees> list = new ArrayList<Employees>(); // 다형성
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
			conn = DBHelp.getConncetion();
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
				DBHelp.close(rs, stmt, conn);
			}
		return list;
	}
	
	// 사원의 최대 갯수를 구하는 메소드
   public int selectEmpNo(String str) {
	   int empNo = 0;
	    Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		if(str.equals("max")) {
			sql = "SELECT MAX(emp_no) FROM employees";
		   } else if(str.equals("min")) {
			   sql = "SELECT MIN(emp_no) FROM employees";
		   }
		try {
			conn = DBHelp.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				empNo = rs.getInt(1);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBHelp.close(rs, stmt, conn);
			}
	   return empNo;
	  }
	
	// 사원의 인구수(성별로 나눴을경우)
	public List<Map<String, Object>> selectEmployeesCountGroupByGender() {
		   List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sql = "SELECT gender, count(gender) as cnt from employees GROUP BY gender";
		   
		   try {
			   conn = DBHelp.getConncetion();
			   stmt = conn.prepareStatement(sql);
			   rs = stmt.executeQuery();
			   while(rs.next()) {
				   Map<String, Object> map = new HashMap<String, Object>();
				   map.put("gender", rs.getString("gender"));
				   map.put("cnt", rs.getInt("cnt"));
				   list.add(map);
			   }
			   
		   } catch(Exception e) {
			   e.printStackTrace();
		   } finally {
				   DBHelp.close(rs, stmt, conn);
		   }
		   return list;
	   }
	
	// 검색을할때, 시작과 끝을 선택해서 그 리스트를 보여주는 메서드
	   public List<Employees> selectEmployeesListBetween(int begin, int end) {
			System.out.println("begin : " + begin);
			System.out.println("end" + end);
			List<Employees> list = new ArrayList<Employees>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no BETWEEN ? AND ? ORDER BY emp_no ASC";
			
			try {
				conn = DBHelp.getConncetion();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, begin);
				stmt.setInt(2, end);
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
					DBHelp.close(rs, stmt, conn);
				}
			return list;
		}
	   
	   // employees의 리스트를 페이징 작업해서 보여주는 메서드
	   public List<Employees> selectEmployeesListByPage(int currentPage, int rowPerPage) {
		   List<Employees> list = new ArrayList<Employees>();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   
		   String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?, ?";
		   try {
			   conn = DBHelp.getConncetion();
			   stmt = conn.prepareStatement(sql);
			   int startRow = ( currentPage - 1 ) * rowPerPage;
			   stmt.setInt(1, startRow);
			   stmt.setInt(2, rowPerPage);
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
			   DBHelp.close(rs, stmt, conn);
		   }
		   return list;
	   }
	   
	   // 페이징 작업 마지막 페이지를 설정할 메서드
	   public int selectLastPage(int rowPerPage) {
		   int lastPage = this.selectEmployeesCount();
		   if(lastPage % rowPerPage > 0) {
			   lastPage++;
		   }
		   return lastPage;
	   }
	   
	// 로그인시 empNo를 받을 메서드
	   public String login(Employees employees) {
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sessionEmpNo = null;
		   
		   System.out.println(employees.getEmpNo());
		   
		   String sql = "select emp_no from employees where emp_no = ? and first_name = ? and last_name = ?";
		   try {
			   conn = DBHelp.getConncetion();
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, employees.getEmpNo());
			   stmt.setString(2, employees.getFirstName());
			   stmt.setString(3, employees.getLastName());
			   rs = stmt.executeQuery();
			   if(rs.next()) {
				   sessionEmpNo = rs.getString("emp_no");
			   }
		   } catch(Exception e) {
			   e.printStackTrace();
		   } finally {
			   DBHelp.close(rs, stmt, conn);
		   }
		   return sessionEmpNo;
	   }
}














