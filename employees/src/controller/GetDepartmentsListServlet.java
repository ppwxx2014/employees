package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import vo.Department;


@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// servlet의 요청을 받고 model호출
		departmentsDao = new DepartmentsDao();
		
		List<Department> list = departmentsDao.selectDepartmentsList();
		
		// view로 보내기 전에 list를 request에 저장
		request.setAttribute("list", list);
		
		// 보낼 주소
		String path = "/WEB-INF/views/department/departmentsList.jsp";
		// view로 포워딩해줌
		request.getRequestDispatcher(path).forward(request, response);
	}
}
