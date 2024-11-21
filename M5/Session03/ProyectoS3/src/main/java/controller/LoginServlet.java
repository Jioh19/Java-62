package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import repository.ProductoRepository;
import repository.UsuarioRepository;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/login", "/logout"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioRepository usuarioRepository;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		usuarioRepository = new UsuarioRepository();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eleccion = request.getServletPath();
		if(eleccion.equals("/logout")) {
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
				System.out.println("Estamos haciendo logout");
			}
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Usuario usuario = usuarioRepository.getByUsername(username);
		if(usuario != null) {
			if(usuario.getPassword().equals(password) ) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60*30);
				ProductoRepository productoRepository = new ProductoRepository();
				session.setAttribute("productos", productoRepository.getAll());
				request.getRequestDispatcher("productos.jsp").forward(request, response);
				//response.sendRedirect("productos.jsp");
			} else {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciales inválidas");
			}
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciales inválidas");
			
		}
	}

}
