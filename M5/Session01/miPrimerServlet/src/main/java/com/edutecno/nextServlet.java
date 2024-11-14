package com.edutecno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class nextServlet
 */
@WebServlet("/nextServlet")
public class nextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Llegamos el NEXT SERVLET!!!!!!");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		PrintWriter write =response.getWriter();
		write.println("<html><body>");
		write.println("Datos:</br>");
		write.println("Nombre: "+nombre+ "</br>");
		write.println("Apellido: "+apellido+ "</br>");
		write.println("Direccion: "+direccion+ "</br>");
		write.println("</html> </body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
