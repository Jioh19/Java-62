package com.edutecno.gutenDex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.gutenDex.dto.AutorDto;
import com.edutecno.gutenDex.model.Autor;
import com.edutecno.gutenDex.model.Libro;
import com.edutecno.gutenDex.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;
	
	public Autor agregarAutor(AutorDto autorDto, Libro libro) {
		List<Libro> libros = new ArrayList<Libro>();
		Autor autor;
		if(autorRepository.checkAutor(autorDto.getName())) {
			System.out.println("Autor ya ingresado");
			autor = autorRepository.findByName(autorDto.getName());
			libros = autor.getLibros();
			libros.add(libro);
			autor.setLibros(libros);
			return autor;
		} 
		
		libros.add(libro);
		autor = new Autor();
		autor.setName(autorDto.getName());
		autor.setFechaDeNacimiento(autorDto.getFechaDeNacimiento());
		autor.setFechaDeDeceso(autorDto.getFechaDeDeceso());
		autor.setLibros(libros);
		autorRepository.save(autor);
		return autor;
		
	}
}
