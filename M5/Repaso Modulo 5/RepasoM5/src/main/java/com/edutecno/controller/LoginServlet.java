package com.edutecno.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.edutecno.dao.UsuarioDaoImpl;
import com.edutecno.model.Usuario;
import com.edutecno.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService loginService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        loginService = new LoginService();
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username + " " + password);
		if(loginService.login(username, password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciales inválidas");
		}
//		UsuarioDaoImpl dao = new UsuarioDaoImpl();
//		dao.loadFromFiles();
//		List<Usuario> usuarios = dao.getAll();
//		usuarios.forEach(System.out::println);
//		Usuario usuario = null;
//		for(Usuario u : usuarios) {
//			if(u.getUsername().equals(username)) {
//				usuario = u;
//				if(usuario.getPassword().equals(password)) {
//					HttpSession session = request.getSession(true);
//					session.setAttribute("username", username);
//					response.sendRedirect(request.getContextPath() + "/index.jsp");
//				} else {
//					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciales inválidas");
//				}
//			}
//		}
//		if(usuario == null) {
//			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciales inválidas");
//			
//		}
		
		
	}

}
