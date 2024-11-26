package com.edutecno;

import com.edutecno.entities.CursoDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CursoDTO curso = new CursoDTO();
		curso.setIdCurso(1);
		curso.setDescripcion("Curso de Java");
		curso.setPrecio(10000000);
		System.out.println(curso);
		
		
	}

}
