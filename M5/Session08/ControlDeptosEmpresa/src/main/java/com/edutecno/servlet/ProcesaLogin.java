package com.edutecno.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.dao.EmpleadoDaoImp;
import com.edutecno.dao.LoginDaoImp;
import com.edutecno.modelo.Empleado;

/**
 * Servlet implementation class ProcesaLogin
 */
@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesaLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean usuarioExiste = false;
		String nombre = request.getParameter("nombre");
		String id = request.getParameter("id");
		String depto = request.getParameter("depto");
		LoginDaoImp loginDao = new LoginDaoImp();
		usuarioExiste = loginDao.usuarioRegistrado(Integer.parseInt(id), nombre, Integer.parseInt(depto));
		// request.setAttribute("usuarioExiste", usuarioExiste);
		if (usuarioExiste) {
			EmpleadoDaoImp dao = new EmpleadoDaoImp();
			List<Empleado> empleados = dao.getAll();
			System.out.println(empleados);
			request.setAttribute("empleados", empleados);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("login.html").forward(request, response);
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
