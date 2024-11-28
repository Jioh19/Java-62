package com.edutecno.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.dao.DepartamentoDaoImp;
import com.edutecno.modelo.Departamento;

/**
 * Servlet implementation class ProcesaDepartamento
 */
@WebServlet("/procesaDepartamento")
public class ProcesaDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaDepartamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Departamento> deptos = new ArrayList<>();
		DepartamentoDaoImp deptoDao = new DepartamentoDaoImp();
		deptos = deptoDao.obtieneDepartamento();
		request.setAttribute("deptoDao",
				deptos);
		request.getRequestDispatcher("resultado.jsp").forward(request,
				response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
