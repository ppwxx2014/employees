package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		System.out.println("--------------사원리스트 페이징--------------");
		// currentPage , rowPerPage받음
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("currentPage : " + currentPage);
		
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		System.out.println("rowPerPage : " + rowPerPage);
		
		// 페이징 작업 ==> 마지막 페이지 설정
		int lastPage = employeesDao.selectLastPage(rowPerPage);
		System.out.println("lastPage : " + lastPage);
		
		// 리스트 출력
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		
		// request에 내용을 저장해서 보내줌
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("list", list);
		
		// 포워딩
		request.getRequestDispatcher("/WEB-INF/views/employees/getEmployeesListByPage.jsp").forward(request, response);
	}
}









