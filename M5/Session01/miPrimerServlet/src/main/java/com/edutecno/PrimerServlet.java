package com.edutecno;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/PrimerServlet")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entraron al metodo do get!!!");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter write =response.getWriter();
		String nombre = request.getParameter("nombre");
		String edadStr = request.getParameter("edad");
		int edad = 0;
		if(edadStr != null && edadStr != "") {
			edad = Integer.parseInt(request.getParameter("edad"));
		}
//		String html = """
//				<html>
//					<body>
//						<h1>Hola mundo!!!!!</h1>
//					</body>
//				</html>
//				""";
		write.println("<html><body>");
		write.println("Datos:</br>");
		write.println("Nombre: "+nombre+ "</br>");
		write.println("Edad: "+edad);
		write.println("</html> </body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entraron al metodo de post!!!!");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(direccion);
//		RequestDispatcher rd = request.getRequestDispatcher("/nextServlet");
//		rd.forward(request, response);
		request.getRequestDispatcher("/nextServlet").forward(request, response);
		//var edad = Integer.parseInt(request.getParameter("edad"));
		//doGet(request, response);
	}

}
