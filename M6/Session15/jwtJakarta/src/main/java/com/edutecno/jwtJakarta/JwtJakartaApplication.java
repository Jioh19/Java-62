package com.edutecno.jwtJakarta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.edutecno.jwtJakarta.model.Roles;
import com.edutecno.jwtJakarta.model.Usuario;
import com.edutecno.jwtJakarta.repository.UsuarioRepository;

@SpringBootApplication
public class JwtJakartaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JwtJakartaApplication.class, args);
	}

	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	PasswordEncoder encoder;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setUsername("jioh11");
		usuario.setEmail("jioh@mail.com");
		usuario.setPassword(encoder.encode("123456"));
		usuario.setRol(Roles.ADMIN);
		
		repo.save(usuario);
		Usuario usuario2 = new Usuario();
		usuario2.setUsername("mtoro");
		usuario2.setEmail("jioh@mail.com");
		usuario2.setPassword(encoder.encode("123456"));
		usuario2.setRol(Roles.USER);
		repo.save(usuario2);
	}

}
