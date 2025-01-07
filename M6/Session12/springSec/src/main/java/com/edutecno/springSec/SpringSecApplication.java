package com.edutecno.springSec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.edutecno.springSec.model.Usuario;
import com.edutecno.springSec.repository.UsuarioRepository;

@SpringBootApplication
public class SpringSecApplication implements CommandLineRunner{

	@Autowired
	UsuarioRepository repoU;
	
	@Autowired
	PasswordEncoder pass;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
	
		Usuario usuario = new Usuario();
		usuario.setUsername("Pedro");
		usuario.setPassword(pass.encode("pedro"));
		usuario.setRole("CLIENT");
		Usuario usuario1 = new Usuario();
		usuario1.setUsername("jioh");
		usuario1.setPassword(pass.encode("jioh"));
		usuario1.setRole("ADMIN");
		
		repoU.save(usuario);
		repoU.save(usuario1);
		
		System.out.println(repoU.findAll());
	}

}
