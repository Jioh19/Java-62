package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.entities.CursoDTO;
import com.edutecno.util.ConexionBD;

public class CursoDAO {
	public List<CursoDTO> obtenerCursos() {
		List<CursoDTO> cursos = new ArrayList<>();

		String sql = "SELECT * FROM CURSOS";
		try {
		
			Connection conexion = ConexionBD.getConexion();

			PreparedStatement stmt = conexion.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				CursoDTO cursoDto = new CursoDTO();
				cursoDto.setIdCurso(resultado.getInt("id_curso"));
				cursoDto.setDescripcion(resultado.getString("descripcion"));
				cursoDto.setPrecio(resultado.getInt("precio"));
				cursos.add(cursoDto);
			}

		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cursos;
	}
	
	public static void main(String[] args) {
		CursoDAO dao = new CursoDAO();
		try {
			List<CursoDTO> cursos = dao.obtenerCursos();
			cursos.stream().forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
