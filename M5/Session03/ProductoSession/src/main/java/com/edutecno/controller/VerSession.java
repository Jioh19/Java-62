package com.edutecno.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.edutecno.model.Producto;

/**
 * Servlet implementation class VerSession
 */
@WebServlet("/VerSession")
public class VerSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Producto producto = (Producto) session.getAttribute("producto");
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<h1>Producto id: " + producto.getId() + "</h1>");
		writer.println("<h1>Nombre producto: " + producto.getConcepto() + "</h1>");
		writer.println("<h1>Valor producto: " + producto.getImporte() + "</h1>");
		writer.println("</body></html>");
	//	session.invalidate();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
