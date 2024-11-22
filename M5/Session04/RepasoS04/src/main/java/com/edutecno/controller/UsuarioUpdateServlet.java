package com.edutecno.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Usuario;

/**
 * Servlet implementation class UsuarioUpdateServlet
 */
@WebServlet("/UsuarioUpdateServlet")
public class UsuarioUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioUpdateServlet() {
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
		String id = request.getParameter("id");
		Usuario usuario = null;

		// conexion a la base de datos y ejecucion de la sentencia
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
			Connection conn = DriverManager.getConnection(url, "JIOH", "1160");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO WHERE id = " + id);

			if (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));

			}

//					for(Usuario usuario: usuarios) {
//						System.out.println(usuario);
//					}

			// usuarios.stream().forEach(System.out::println);
			if(usuario != null ){
				request.setAttribute("usuario", usuario);
			}
			System.out.println(usuario);
		//	request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		String id = request.getParameter("id");

		// conexion a la base de datos y ejecucion de la sentencia
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
			Connection conn = DriverManager.getConnection(url, "JIOH", "1160");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM USUARIO WHERE id = " + id);



//					for(Usuario usuario: usuarios) {
//						System.out.println(usuario);
//					}


		//	request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
