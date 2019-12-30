package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import model.SalariesDao;

@WebServlet("/salaries/getSalariesStatistics")
public class GetSalariesStatisticsServlet extends HttpServlet {
	private SalariesDao salariesDao;
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션을 받음
		HttpSession session = request.getSession();
		
		// 처음 접속이거나, 로그인을 안했을 경우
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		salariesDao = new SalariesDao();
		
		Map<String, Long> map = salariesDao.selectSalariesStatistics();
		
		request.setAttribute("map", map);
		
		
		employeesDao = new EmployeesDao();
		
		List<Map<String, Object>> list = employeesDao.selectEmployeesCountGroupByGender();
		
		request.setAttribute("list", list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/salaries/salariesStatistics.jsp").forward(request, response);
	}
}
