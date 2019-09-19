package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		
		// EmployeesDao employeesDao = new EmployeesDao();
		// 모델 호출
		this.employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesCount();
		
		request.setAttribute("employeesRowCount", employeesRowCount);
		// request에 employeesRowCount를 저장함 (MAP타입) -> 참조타입으로 저장해야 하지만, Wrapper클래스에서 auto-boxing되서 Integer타입으로 자동 형변환됨
		
		// /WEB-INF/views/index.jsp
		// RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");	
		rd.forward(request, response);
		
		
	}
}
