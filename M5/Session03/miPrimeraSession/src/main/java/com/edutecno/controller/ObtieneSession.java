package com.edutecno.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import miPrimeraSession.EntradaConcierto;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ObtieneSession
 */
@WebServlet("/ObtieneSession")
public class ObtieneSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObtieneSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EntradaConcierto entradas = (EntradaConcierto) session.getAttribute("entrada");
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<h1>Entradas para " + entradas.getNombreArtista() + "</h1>");
		writer.println("<h1>A nombre de " + entradas.getTitularEntrada() + "</h1>");
		writer.println("</body></html>");
	//	session.invalidate();
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
