package com.edutecno.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Categoria;
import com.edutecno.util.ConexionDB;

public class CategoriaDaoImpl extends ConexionDB implements Dao<Categoria>{
	private Connection conn;
	
	public CategoriaDaoImpl() {
		super();
		conn = generaConexion();
	}

	@Override
	public List<Categoria> getAll() {
		List<Categoria> categorias = new ArrayList<>();
		try(Statement stmt = conn.createStatement()) {
			String sql = "SELECT * FROM CATEGORIAS";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setIdCategoria(rs.getInt("id_categoria"));
				c.setNombre(rs.getString("nombre"));
				categorias.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public Categoria getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Categoria getByNombre(String nombre) {
		
		List<Categoria> categorias = getAll();
		for(Categoria cat: categorias) {
			if(cat.getNombre().equals(nombre)) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public void save(Categoria t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
