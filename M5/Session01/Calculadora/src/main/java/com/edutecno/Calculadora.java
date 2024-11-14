package com.edutecno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Calculadora
 */
@WebServlet("/Calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculadora() {
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

		PrintWriter pw = response.getWriter();
		String html = """
				<!DOCTYPE html>
				<html lang="en">
				<head>
				  <meta charset="UTF-8">
				  <meta name="viewport" content="width=device-width, initial-scale=1.0">
				  <title>Document</title>
				</head>
				<body>
				  <form action="Calculadora" method="POST">
				    <label for="num1">Número 1</label>
				    <input type="number" name="num1" required>
				    <label for="num2">Número 2</label>
				    <input type="number" name="num2" required>
				    <label for="operacion">Operación</label>
				    <select name="operacion">
				      <option value="suma">Suma</option>
				      <option value="resta">Resta</option>
				      <option value="mult">Multiplicación</option>
				      <option value="div">División</option>
				    </select>
				    <button type="submit">Calcular</button>
				  </form>
				</body>
				</html>
												""";
		pw.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("operacion");
		System.out.println(num1 + " " + num2 + " " + op);
		int resultado = 0;
		switch (op) {
		case "suma":
			resultado = num1 + num2;
			break;
		case "resta":
			resultado = num1 - num2;
			break;
		case "mult":
			resultado = num1 * num2;
			break;
		case "div":
			try {
				// resultado = num2 != 0 ? num1/num2: 0;
				resultado = num1 / num2;
			} catch (ArithmeticException e) {
				System.out.println("No se debe dividir por 0");
			}
			break;
		}

		System.out.println("El resultado es: " + resultado);

		PrintWriter pw = response.getWriter();
		String inicio = """
								<!DOCTYPE html>
				<html lang="en">
				<head>
				  <meta charset="UTF-8">
				  <meta name="viewport" content="width=device-width, initial-scale=1.0">
				  <title>Document</title>
				</head>
				<body>
				  <h1>El resultado es</h1>
								""";
		String fin = """
				 <a href="Calculadora"><button>Volver</button></a>
				</body>
				</html>
				""";
		pw.println(inicio);
		pw.println("<p>" + num1 + " " + op + " " + num2 + "</p>");
		pw.println("<p>Resultado: " + resultado + "</p>");
		pw.println(fin);
	}

}
