package com.edutecno.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.edutecno.Facade;
import com.edutecno.entities.CursoDTO;
import com.edutecno.entities.FormaPagoDTO;

/**
 * Servlet implementation class PreInscripcion
 */
@WebServlet("/preInscripcion")
public class PreInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreInscripcion() {
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
		Facade facade = new Facade();
		try {
			// se obtiene la lista de cursos con el objeto facade
			List<CursoDTO> listaCursos = null;
			List<FormaPagoDTO> listaFormasPago = null;
			try {
				listaCursos = facade.obtenerCursos();
				System.out.println(listaCursos);
				
				listaFormasPago = facade.obtenerFormasDePago();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			// se guardan las listas al request
			request.setAttribute("cursos", listaCursos);
			request.setAttribute("formasPago", listaFormasPago);
			// se redirecciona el request a la página jsp
			request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
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
