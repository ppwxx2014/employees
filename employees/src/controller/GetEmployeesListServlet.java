package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;

@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션을 받음
		HttpSession session = request.getSession();
		
		// 처음 접속이거나, 로그인을 안했을 경우
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		// get방식을 통해 뒤에 붙을 limit값 설정
			int limit = 30;
			if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
				}
			System.out.println("보여줄 갯수 : " + limit);
			
			// servlet의 요청을 받고 model에서 Dao호출
			employeesDao = new EmployeesDao();
			List<Employees> list = employeesDao.selectEmployeesListByLimit(limit);
			
			// View로 갈떄 request와 response만 넘어가기 떄문에 request에 list의 값을 저장해서 포워딩해줌
			request.setAttribute("list", list);
			
			// forward해줄 주소 입력
			String path = "/WEB-INF/views/employees/employeesList.jsp"; // view 주소
			request.getRequestDispatcher(path).forward(request, response);
	}
}
