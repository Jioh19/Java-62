package com.edutecno.gutenDex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.gutenDex.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	LibroRepository libroRepository;
	
	
}
