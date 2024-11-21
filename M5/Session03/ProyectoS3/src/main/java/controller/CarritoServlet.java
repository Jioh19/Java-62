package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/carro/agregar")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Map<String, Integer> carro = getCarroFromCookies(request);
		//Map<String, Integer> carro = new HashMap<>();
		addCarro(carro, id);
		saveCookies(response, carro);
		
		System.out.println(carro);
		response.sendRedirect("/ProyectoS3/productos.jsp");
		//request.getRequestDispatcher("/ProyectoS3/productos.jsp").forward(request, response);
	}

	private Map<String, Integer> getCarroFromCookies(HttpServletRequest request) {
		Map<String, Integer> carro = new HashMap<>();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie: cookies ) {
				if(cookie.getName().startsWith("00", 0)) {
					String id = cookie.getName();
					Integer val = Integer.parseInt(cookie.getValue());
					carro.put(id, val);	
					System.out.println(cookie.getPath());
				}
			}
		}
		return carro;
	}
	
	private void saveCookies(HttpServletResponse response, Map<String, Integer> carro) {
		for(Map.Entry<String, Integer> entry: carro.entrySet()) {
			Cookie cookie = new Cookie(entry.getKey(), String.valueOf(entry.getValue()));
			response.addCookie(cookie);
		}
	}
	
	private void addCarro(Map<String, Integer> carro, String id) {
		carro.put(id, carro.getOrDefault(id, 0) +1);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
