package com.edutecno.springJDBC;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.springJDBC.repository.UsuarioRepositorio;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Autowired
	DataSource dataSource;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Override
	public void run(String... args) throws Exception {
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		System.out.println("Create:");
		System.out.println("Creando usuario Juan");
		usuarioRepositorio.createUsuario(1l, "Juan");
		System.out.println("Creando usuario Maria");
		usuarioRepositorio.createUsuario(2l, "Maria");
		System.out.println("======");
		System.out.println("Read:");
		System.out.println(usuarioRepositorio.getUsuarioById(1l));
		System.out.println(usuarioRepositorio.getUsuarioById(2l));
		System.out.println("======");
		System.out.println("Update:");
		usuarioRepositorio.updateUsuarioById(1l, "Destructor70");
		usuarioRepositorio.updateUsuarioById(2l, "LadyDoom");
		System.out.println(usuarioRepositorio.getUsuarios());
		System.out.println("======");
		System.out.println("Delete:");
		System.out.println("Borrando usuario con id 1");
		usuarioRepositorio.deleteUsuarioById(1l);
		usuarioRepositorio.deleteUsuarioById(2l);
		System.out.println(usuarioRepositorio.getUsuarios());

	}
}
