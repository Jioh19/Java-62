package com.edutecno.springJDBC.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.edutecno.springJDBC.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getLong("id"));
		usuario.setNombre(rs.getString("nombre"));
		return usuario;
	}

}
