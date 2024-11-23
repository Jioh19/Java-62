package com.edutecno;

import java.sql.SQLException;
import java.util.List;

import com.edutecno.dao.CursoDAO;
import com.edutecno.dao.FormaPagoDAO;
import com.edutecno.dao.InscripcionDAO;
import com.edutecno.entities.CursoDTO;
import com.edutecno.entities.FormaPagoDTO;
import com.edutecno.entities.InscripcionDTO;

public class Facade {
	public int registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();
		return dao.insertarInscripcion(dto);
	}

	// metodo nuevo desafio
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();
		return dao.obtieneInscripciones();
	}

	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException {
		CursoDAO dao = new CursoDAO();
		return dao.obtenerCursos();
	}

	public List<FormaPagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException {
		FormaPagoDAO dao = new FormaPagoDAO();
		return dao.obtieneFormasDePago();
	}
	
	public static void main(String[] args) {
		Facade fac = new Facade();
		try {
			fac.obtenerCursos().stream().forEach(System.out::println);
			fac.obtieneInscripciones().stream().forEach(System.out::println);
			fac.obtenerFormasDePago().stream().forEach(System.out::println);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
