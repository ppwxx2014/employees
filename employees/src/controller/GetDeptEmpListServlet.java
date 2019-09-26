package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeptEmpDao;
import vo.DeptEmp;

@WebServlet("/deptEmp/getDeptEmpList")
public class GetDeptEmpListServlet extends HttpServlet {
	private DeptEmpDao deptEmpDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("---deptEmp실행---");
		
		deptEmpDao = new DeptEmpDao();
		
		// currentPage, rowPerPage, lastPage를 받아서 페이징작업
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int rowPerPage = 20;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		int lastPage = deptEmpDao.selectDeptEmpCount();
		
		//list에 return값을 복사하기 위해 생성
		List<DeptEmp> list = deptEmpDao.selectDeptEmpList(currentPage, rowPerPage);
		
		//request에 받아온 값 저장 해서 포워딩 해줌
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.getRequestDispatcher("/WEB-INF/views/deptEmp/deptEmpList.jsp").forward(request, response);
	}
}







