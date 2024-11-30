package com.edutecno.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.dao.EmpleadoDaoImp;
import com.edutecno.modelo.Empleado;

/**
 * Servlet implementation class ProcesaBusquedaEmpleado
 */
@WebServlet("/procesaBusquedaEmpleado")
public class ProcesaBusquedaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaBusquedaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		String nombre = request.getParameter("nombre");
		String numEmpleado = request.getParameter("id");
		String numDepartamento = request.getParameter("depto");
		if (numEmpleado.isEmpty()) {
		numEmpleado = "0";
		}
		if (numDepartamento.isEmpty()) {
		numDepartamento = "0";
		}
		EmpleadoDaoImp busqueda = new EmpleadoDaoImp();
		listaEmpleados = busqueda.busquedaEmpleado(nombre,
		Integer.parseInt(numEmpleado), Integer.parseInt(numDepartamento));
		System.out.println(listaEmpleados);
		request.setAttribute("empleados", listaEmpleados);
		request.getRequestDispatcher("index.jsp").forward(request,
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
