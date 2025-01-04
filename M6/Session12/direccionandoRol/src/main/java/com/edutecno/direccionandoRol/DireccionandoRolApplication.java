package com.edutecno.direccionandoRol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.edutecno.direccionandoRol.model.Users;
import com.edutecno.direccionandoRol.repository.UsersRepository;

@SpringBootApplication
public class DireccionandoRolApplication implements CommandLineRunner{

	@Autowired
	UsersRepository repo;
	
	@Autowired 
	BCryptPasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DireccionandoRolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Users usuario1 = new Users(1, "user@mail.com", encoder.encode("user"), "CLIENT");
		Users usuario2 = new Users(2, "admin@mail.com", encoder.encode("admin"), "ADMIN");
		repo.save(usuario1);
		repo.save(usuario2);
		
		repo.findAll().forEach(System.out::println);
	}

}
