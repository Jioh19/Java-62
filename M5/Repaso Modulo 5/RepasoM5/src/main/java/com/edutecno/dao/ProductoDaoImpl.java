package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;
import com.edutecno.util.ConexionDB;

public class ProductoDaoImpl extends ConexionDB implements Dao<Producto>{
	private Connection conn;
	private static List<Categoria> categorias;
	
	public ProductoDaoImpl() {
		super();
		conn = generaConexion();
		CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
		categorias = categoriaDao.getAll();
	}

	@Override
	public List<Producto> getAll() {
		List<Producto> productos = new ArrayList<>();
		try(Statement stmt = conn.createStatement()) {
			String sql = "SELECT * FROM PRODUCTOS";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt("id_producto"));
				p.setNombre(rs.getString("nombre"));
				p.setCategoria(categorias.get(rs.getInt("id_categoria")));
				productos.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	public Producto getById(int id) {
		Producto p = new Producto();
		String sql  = "SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				p.setIdProducto(rs.getInt("id_producto"));
				p.setNombre(rs.getString("nombre"));
				p.setCategoria(categorias.get(rs.getInt("id_categoria")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void save(Producto t) {
		String sql = "INSERT INTO PRODUCTOS VALUES(?,?,?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, t.getIdProducto());
			stmt.setString(2, t.getNombre());
			stmt.setInt(3, t.getCategoria().getIdCategoria());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
