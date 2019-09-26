package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logoutSerlvet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션을 닫고 원래 페이지를 요청함
		HttpSession session = request.getSession();
		session.invalidate();
		// 로그아웃되면, 로그인창으로 이동
		response.sendRedirect(request.getContextPath() + "/l	ogin");
	}
}

