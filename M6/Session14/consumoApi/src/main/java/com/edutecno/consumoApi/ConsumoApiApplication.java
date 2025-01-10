package com.edutecno.consumoApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.consumoApi.service.UsuarioService;

@SpringBootApplication
public class ConsumoApiApplication implements CommandLineRunner{

	@Autowired
	UsuarioService service;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(service.findAll());
	}

}
