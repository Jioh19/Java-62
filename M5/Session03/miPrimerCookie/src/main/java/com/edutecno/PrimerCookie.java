package com.edutecno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PrimerCookie
 */
@WebServlet("/PrimerCookie")
public class PrimerCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrimerCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie cookie = new Cookie("miCookie", "69420");
		Cookie cookie2 = new Cookie("miSegunda", "123456");
		
		cookie.setMaxAge(60*60*2);
		response.addCookie(cookie);
		response.addCookie(cookie2);
		PrintWriter print = response.getWriter();
		print.println("<html><body>");
		print.println("<h2><i>Cookie guardada correctamente:</i></h2><br>");
		print.println("Valor de la cookie: "+ "<strong>" + cookie.getValue() + cookie.getName() + "</strong>");
		print.println("<br>" + "<strong>"+cookie.getMaxAge()+"</strong>");
		print.println("Valor de la cookie: "+ "<strong>" + cookie.getValue() +"<br>");
		print.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
