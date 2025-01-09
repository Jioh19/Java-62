package com.edutecno.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.api.dao.UsuarioDao;
import com.edutecno.api.model.Usuario;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	@Autowired
	UsuarioDao dao;
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.save(new Usuario(1, "Juan", "10-02-1982"));
		dao.save(new Usuario(2, "Marcelo", "10-02-1982"));
		dao.save(new Usuario(3, "Fernando", "10-02-1982"));
		dao.save(new Usuario(4, "Sebastian", "10-02-1982"));
		System.out.println(dao.findAll());
	}

}
