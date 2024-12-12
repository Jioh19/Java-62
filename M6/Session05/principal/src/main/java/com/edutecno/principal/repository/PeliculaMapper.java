package com.edutecno.principal.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.edutecno.principal.model.Pelicula;

public class PeliculaMapper implements RowMapper<Pelicula>{

	@Override
	public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelicula pelicula = new Pelicula();
		pelicula.setId(rs.getInt("id"));
		pelicula.setTitulo(rs.getString("titulo"));
		pelicula.setDirector(rs.getString("director"));
		pelicula.setAnio(rs.getInt("anio"));
		pelicula.setDuracion(rs.getInt("duracion"));
		return pelicula;
	}

}
