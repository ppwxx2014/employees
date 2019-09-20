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

@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식을 통해 뒤에 붙을 limit값 설정
			int limit = 30;
			if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
				}
			System.out.println("보여줄 갯수 : " + limit);
			
			// list를 보여줌
			employeesDao = new EmployeesDao();
			List<Employees> list = employeesDao.selectEmployeesListByLimit(limit);
			
			// View로 갈떄 request와 response만 넘어가기 떄문에 request에 list의 값을 저장해서 포워딩해줌
			request.setAttribute("list", list);
			
			// forward해줄 주소 입력
			request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}
}
