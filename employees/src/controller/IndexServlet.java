package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import model.DeptEmpDao;
import model.DeptManagerDao;
import model.EmployeesDao;
import model.SalariesDao;
import model.TitlesDao;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptManagerDao deptManagerDao;
	private DeptEmpDao deptEmpDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		
		employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesCount();
		
		departmentsDao = new DepartmentsDao();
		int departmentsRowCount = departmentsDao.selectDepartmentsCount();
		
		deptManagerDao = new DeptManagerDao();
		int deptManagerRowCount = deptManagerDao.selectDeptManagerCount();
		
		deptEmpDao = new DeptEmpDao();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpCount();
		
		salariesDao = new SalariesDao();
		int salariesRowCount = salariesDao.selectSalariesCount();
		
		titlesDao = new TitlesDao();
		int titlesRowCount = titlesDao.selectTitlesCount();
		
		System.out.println("emp테이블의 총 갯수 : " + employeesRowCount);
		System.out.println("departments테이블의 총 갯수 : " + departmentsRowCount);
		System.out.println("deptManager테이블의 총 갯수 : " + deptManagerRowCount);
		System.out.println("deptEmp테이블의 총 갯수 : " + deptEmpRowCount);
		System.out.println("salaries테이블의 총 갯수 : " + salariesRowCount);
		System.out.println("titles테이블의 총 갯수 : " + titlesRowCount);
		
		// 총 갯수를 받기위해 request에 count를 저장함
		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount); 
		
		// /WEB-INF/views/index.jsp
		// RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");	
		rd.forward(request, response);		
	}
}
