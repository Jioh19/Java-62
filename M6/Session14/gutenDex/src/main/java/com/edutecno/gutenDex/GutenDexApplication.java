package com.edutecno.gutenDex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.gutenDex.dto.LibroDto;
import com.edutecno.gutenDex.service.ResultService;

@SpringBootApplication
public class GutenDexApplication implements CommandLineRunner{

	@Autowired
	ResultService service;
	
	public static void main(String[] args) {
		SpringApplication.run(GutenDexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<LibroDto> libros = service.getAll();
		System.out.println(libros);
	}

}
