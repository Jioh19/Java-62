package com.edutecno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Contador
 */
@WebServlet("/Contador")
public class Contador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contador = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		++contador;
		String inicio = """
						<!DOCTYPE html>
				<html lang="en">
				<head>
				  <meta charset="UTF-8">
				  <meta name="viewport" content="width=device-width, initial-scale=1.0">
				  <title>Document</title>
				</head>
				<body>
				  <h1>Contador de visitas</h1>
						""";
		String fin = """
						 <a href="Contador"><button>Actualizar</button></a>
				</body>
				</html>
						""";
		try (PrintWriter pw = response.getWriter()) {

			pw.println(inicio);
			pw.println("<p>Esta página ha sido visitada " + contador + " veces</p>");
			pw.println(fin);
		} 

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
