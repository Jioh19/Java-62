package com.edutecno.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.edutecno.model.Producto;
import com.edutecno.service.CategoriaService;
import com.edutecno.service.ProductoService;

/**
 * Servlet implementation class ActulizarProducto
 */
@WebServlet("/actualizarProducto")
public class ActulizarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaService categoriaService;
	private ProductoService productoService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActulizarProducto() {
        super();
        categoriaService = new CategoriaService();
        productoService = new ProductoService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoService.obtenerPorId(id);
		HttpSession session = request.getSession(false);
		session.setAttribute("producto", producto);
		request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		
		Producto producto = new Producto();
		producto.setIdProducto(id);
		producto.setNombre(nombre);
		producto.setCategoria(categoriaService.obtenerCategoriaPorNombre(categoria));
		productoService.actualizarProducto(producto);
		request.getRequestDispatcher("listarProductos").forward(request, response);
	}

}
