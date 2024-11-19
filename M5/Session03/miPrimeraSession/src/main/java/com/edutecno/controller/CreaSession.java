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
import java.sql.Date;

/**
 * Servlet implementation class CreaSession
 */
@WebServlet("/CreaSession")
public class CreaSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String usuario = request.getParameter("usuario");
		System.out.println(usuario);
		EntradaConcierto entrada = new EntradaConcierto(usuario, "Iron Maiden", "miCasa", Date.valueOf("2024-10-10"));
		PrintWriter print = response.getWriter();
		print.println("<html><body>");
		print.println("<h3>Entradas para " + entrada.getNombreArtista() + "</h3>");
		print.println("<p>A nombre de " + entrada.getTitularEntrada() + "</p>");
		print.println("</body></html>");
		session.setAttribute("entrada", entrada);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
