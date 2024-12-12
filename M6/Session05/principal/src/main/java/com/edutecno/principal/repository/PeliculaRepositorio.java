package com.edutecno.principal.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutecno.principal.model.Pelicula;

@Repository
public class PeliculaRepositorio {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void createPelicula(Pelicula pelicula) {
		String sql = "INSERT INTO PELICULA (ID, TITULO, DIRECTOR, ANIO, DURACION) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(
				sql, 
				pelicula.getId(), 
				pelicula.getTitulo(), 
				pelicula.getDirector(), 
				pelicula.getAnio(), 
				pelicula.getDuracion());
	}
	
	public List<Pelicula> getPeliculas() {
		String sql = "SELECT * FROM PELICULA";
		return jdbcTemplate.query(sql, new PeliculaMapper());
	}
	
	@SuppressWarnings("deprecation")
	public Pelicula getPeliculaById(int id) {
		String sql = "SELECT * FROM PELICULA WHERE ID = ?";
		Object[] valores = new Object[] {
				id
		};
		return jdbcTemplate.queryForObject(sql, valores, new PeliculaMapper());
 	}
	
	public void updatePeliculaById(int id, String titulo, String director, int anio, int duracion) {
		String sql = "UPDATE PELICULA SET TITULO=?, DIRECTOR=?, ANIO=?, DURACION=? WHERE ID=?";
		jdbcTemplate.update(sql, titulo, director, anio, duracion, id);
	}
	
	public void deletePeliculaById(int id) {
		String sql = "DELETE PELICULA WHERE ID =?";
		jdbcTemplate.update(sql,id);
	}
}
