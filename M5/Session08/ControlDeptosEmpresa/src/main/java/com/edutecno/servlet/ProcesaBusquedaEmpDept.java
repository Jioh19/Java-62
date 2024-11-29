package com.edutecno.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.dao.DepartamentoEmpleadoDaoImp;
import com.edutecno.modelo.DepartamentoEmpleado;

/**
 * Servlet implementation class ProcesaBusquedaEmpDept
 */
@WebServlet("/procesaBusquedaEmpDept")
public class ProcesaBusquedaEmpDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesaBusquedaEmpDept() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DepartamentoEmpleadoDaoImp dao = new DepartamentoEmpleadoDaoImp();
		List<DepartamentoEmpleado> list = dao.obtieneDepartamento("REDES");
		System.out.println(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomDepartamento = (String) req.getParameter("nomDepto");
		// lista de tipo DepartamentoEmpleado
		List<DepartamentoEmpleado> deptosEmpleadosList = new ArrayList<DepartamentoEmpleado>();
		DepartamentoEmpleadoDaoImp obtieneDeptoEmpleado = new DepartamentoEmpleadoDaoImp();
		deptosEmpleadosList = obtieneDeptoEmpleado.obtieneDepartamento(nomDepartamento);

		req.setAttribute("departamentoEmpleado", deptosEmpleadosList);
		req.getRequestDispatcher("ListaUnoMuchos.jsp").forward(req, resp);
	}

}
