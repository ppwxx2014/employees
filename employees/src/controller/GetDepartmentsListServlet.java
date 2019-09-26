package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DepartmentsDao;
import vo.Department;


@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션을 받음
		HttpSession session = request.getSession();
		
		// 처음 접속이거나, 로그인을 안했을 경우
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		// 요청을 받고 model호출
		departmentsDao = new DepartmentsDao();
		
		List<Department> list = departmentsDao.selectDepartmentsList();
		
		// view로 보내기 전에 list를 request에 저장
		request.setAttribute("list", list);
		
		// view로 포워딩해줌
		request.getRequestDispatcher("/WEB-INF/views/department/departmentsList.jsp").forward(request, response);
	}
}


	