package com.edutecno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		PrintWriter pw = response.getWriter();
//		String saludo = request.getParameter("saludo");
		String nombre = request.getParameter("nombre").toUpperCase();
		boolean errorNombre = false;
		if(nombre.length() < 4) {
			errorNombre = true;
		}
//		String html = """
//								<!DOCTYPE html>
//				<html lang="en">
//				<head>
//				  <meta charset="UTF-8">
//				  <meta name="viewport" content="width=device-width, initial-scale=1.0">
//				  <title>Document</title>
//				</head>
//				<body>
//				  <p>""";
//		String mid = nombre + " " + saludo;
//		String fin = """
//				   </p>
//				  </body>
//				</html>""";
//		pw.println(html);
//		pw.println(mid);
//		pw.println(fin);
		
		if(!errorNombre) {
			request.setAttribute("NOMBRE", nombre);
			request.getRequestDispatcher("/Saludo.jsp").forward(request, response);	
		} else {
			request.setAttribute("error", errorNombre);
			request.getRequestDispatcher("/miPrimerJSP.jsp").forward(request, response);	
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
