package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;

@WebServlet("/departments/getDepartmentCountByDeptNo")
public class GetDepartmentCountByDeptNo extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentsDao = new DepartmentsDao();
		
		//list에 return값을 복사하기 위해 생성
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = departmentsDao.selectDepartmentsCountByDeptNo();
		//request 에 값을 담는다
		request.setAttribute("list", list);
		//jsp로 forward
		request.getRequestDispatcher("/WEB-INF/views/department/departmentsCountByDeptNo.jsp").forward(request, response);
	}
}
