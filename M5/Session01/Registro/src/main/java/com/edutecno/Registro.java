package com.edutecno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registro() {
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
		String html = """
								<!DOCTYPE html>
				<html lang="en">
				<head>
				  <meta charset="UTF-8">
				  <meta name="viewport" content="width=device-width, initial-scale=1.0">
				  <title>Document</title>
				</head>
				<body>
				  <h1>Ingrese datos para registro</h1>
				  <form action="Registro" method="POST">
				    <label for="username">Username</label>
				    <input type="text" name="username" required>
				    <label for="password">Password</label>
				    <input type="text" name="password" required>
				    <label for="email">Email</label>
				    <input type="text" name="email" required>
				    <button type="submit">Enviar</button>
				  </form>
				</body>
				</html>
								""";
		PrintWriter pw = response.getWriter();
		pw.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println(username + " " + password + " " + email);
		String inicio = """
								<!DOCTYPE html>
				<html lang="en">
				<head>
				  <meta charset="UTF-8">
				  <meta name="viewport" content="width=device-width, initial-scale=1.0">
				  <title>Document</title>
				</head>
				<body>
				  <h1>Registro exitoso!</h1>
								""";
		String fin = """

				  <a href="Registro"><button>Volver</button></a>
				</body>
				</html>
				""";
		PrintWriter pw = response.getWriter();
		pw.println(inicio);
		pw.println("<p>Username: " + username + "</p>\n" +
				  "<p>Email: " + email + "</p>");
		pw.println(fin);
	}

}
