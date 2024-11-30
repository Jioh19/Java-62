package com.edutecno.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.edutecno.dao.EmpleadoDaoImp;
import com.edutecno.modelo.Empleado;

/**
 * Servlet implementation class CreaEmpleado
 */
@WebServlet("/creaEmpleado")
public class CreaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpleadoDaoImp empleadoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
        empleadoDao = new EmpleadoDaoImp();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		empleadoDao.delete(id);
		List<Empleado> empleados = empleadoDao.getAll();
		request.setAttribute("empleados", empleados);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int depto = Integer.parseInt(request.getParameter("depto"));
		Empleado empleado = new Empleado();
		empleado.setNombreEmpleado(nombre);
		empleado.setNumDepto(depto);
		empleadoDao.save(empleado);
		List<Empleado> empleados = empleadoDao.getAll();
		request.setAttribute("empleados", empleados);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
