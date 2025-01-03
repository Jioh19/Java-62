package com.edutecno.miPrimerSpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.edutecno.miPrimerSpringSecurity.model.Usuario;
import com.edutecno.miPrimerSpringSecurity.repository.UsuarioRepository;

@SpringBootApplication
public class MiPrimerSpringSecurityApplication implements CommandLineRunner{

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MiPrimerSpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario(1, "jioh", encoder.encode("12345678"));
		usuarioRepository.save(usuario);
		System.out.println(usuarioRepository.findAll());
		
	}

}
