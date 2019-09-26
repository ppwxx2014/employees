package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TitlesDao;


@WebServlet("/titles/getTitlesListDistinct")
public class GetTitlesListDistinctServlet extends HttpServlet {
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션을 받음
		HttpSession session = request.getSession();
		
		// 처음 접속이거나, 로그인을 안했을 경우
		if(session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		// 객체 생성
		titlesDao = new TitlesDao();
		List<String> list = titlesDao.selectTitlesListDistinct();
		
		// list내용을 request에 저장
		request.setAttribute("list", list);
		
		// views 안에 jsp퐈일로 포워딩
		request.getRequestDispatcher("/WEB-INF/views/titles/getTitlesListDistinct.jsp").forward(request, response);
		
	}
}
