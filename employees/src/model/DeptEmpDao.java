package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelp;
import vo.Department;
import vo.DeptEmp;
import vo.Employees;

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
		
		// 페이징작업까지 완료된 deptEmp에서 departments와 employees테이블 INNER JOIN한 리스트
		public List<DeptEmp> selectDeptEmpList(int currentPage, int rowPerPage) {
			List<DeptEmp> list = new ArrayList<DeptEmp>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "select de.dept_no, d.dept_name, de.emp_no, concat(first_name, ' ', last_name), de.to_date, e.emp_no from departments d INNER JOIN dept_emp de INNER JOIN employees e ON de.dept_no = d.dept_no AND de.emp_no = e.emp_no order by de.to_date asc LIMIT ?,?";
			
			try {
				conn = DBHelp.getConncetion();
				stmt = conn.prepareStatement(sql);
				int startRow = ( currentPage - 1 ) * rowPerPage;
				stmt.setInt(1, startRow);
				stmt.setInt(2, rowPerPage);
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					DeptEmp deptEmp = new DeptEmp();
					
					// department 외래키 참조전 객체 생성
					deptEmp.setDepartment(new Department());
					deptEmp.getDepartment().setDeptName(rs.getString("d.dept_name"));
					deptEmp.getDepartment().setDeptNo(rs.getString("de.dept_no"));
					
					// employees 외래키 참조전 객체 생성
					deptEmp.setEmployees(new Employees());
					deptEmp.getEmployees().setFirstName(rs.getString("concat(first_name, ' ', last_name)"));
					deptEmp.getEmployees().setEmpNo(rs.getInt("de.emp_no"));
					
					deptEmp.setToDate(rs.getString("de.to_date"));
					list.add(deptEmp);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBHelp.close(rs, stmt, conn);
			}
			return list;
		}
		
		// 페이징 작업 마지막 페이지 설정
		   public int selectLastPage(int rowPerPage) {
			   int lastPage = this.selectDeptEmpCount();
			   rowPerPage = 10;
			   if(lastPage % rowPerPage > 0) {
				   lastPage++;
			   }
			   return lastPage;
		   }
}
