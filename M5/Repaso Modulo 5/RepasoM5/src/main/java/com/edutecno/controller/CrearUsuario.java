package com.edutecno.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.edutecno.model.Usuario;
import com.edutecno.service.LoginService;
import com.edutecno.service.UsuarioService;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/crearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoginService usuarioService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        usuarioService = new LoginService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("username");
		String apellido = request.getParameter("apellido");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(nombre, apellido, username, password);
		usuarioService.crearUsuario(usuario);
	}

}
