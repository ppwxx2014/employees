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

@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesListOrderByServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request..order
		String order = request.getParameter("order");
		System.out.println("order 값 : " + order);
		
		employeesDao = new EmployeesDao();
		// 오름차순, 내림차순을 선택하는 메소드 저장
		List<Employees> list = employeesDao.selectEmployeesListOrderBy(order);
		// order값과 같이 저장
		request.setAttribute("list", list);
		// 포워딩
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request, response);
	}
}
