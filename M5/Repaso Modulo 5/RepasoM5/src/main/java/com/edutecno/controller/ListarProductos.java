package com.edutecno.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.dao.CategoriaDaoImpl;
import com.edutecno.dao.ProductoDaoImpl;
import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;

/**
 * Servlet implementation class ListarProductos
 */
@WebServlet("/listarProductos")
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> productos = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
		ProductoDaoImpl productoDao = new ProductoDaoImpl();
		productos = productoDao.getAll();
		categorias = categoriaDao.getAll();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoDao.getById(id);
		
		Producto t = new Producto(4, "Teclado", categorias.get(2));
		productoDao.save(t);
		
		
		
		productos.stream().forEach(System.out::println);
		System.out.println("el id es " + id);
		System.out.println(producto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
