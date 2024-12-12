package com.edutecno.springJDBC.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.edutecno.springJDBC.model.Usuario;

@Repository
public class UsuarioRepositorio {

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public void createUsuario(Long id, String nombre) {
		String sql = "INSERT INTO USUARIO (ID, NOMBRE) VALUES(?,?)";
		jdbcTemplate.update(sql, id, nombre);
	}
	
	public List<Usuario> getUsuarios() {
		String sql = "SELECT * FROM USUARIO";
		return jdbcTemplate.query(sql, new UsuarioMapper());
	}
	
	@SuppressWarnings("deprecation")
	public Usuario getUsuarioById(Long id) {
		String sql = "SELECT * FROM USUARIO WHERE ID = ?";
		Object[] valores = new Object[] {
				id
		};
		return jdbcTemplate.queryForObject(sql, valores, new UsuarioMapper());
 	}
	
	public void updateUsuarioById(Long id, String nombre) {
		String sql = "UPDATE USUARIO SET NOMBRE=? WHERE ID=?";
		jdbcTemplate.update(sql, nombre, id);
	}
	
	public void deleteUsuarioById(Long id) {
		String sql = "DELETE USUARIO WHERE ID =?";
		jdbcTemplate.update(sql,id);
	}
}
