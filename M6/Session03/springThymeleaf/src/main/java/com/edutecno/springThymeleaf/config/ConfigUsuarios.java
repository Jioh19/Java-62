package com.edutecno.springThymeleaf.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edutecno.springThymeleaf.model.Usuario;

@Configuration
public class ConfigUsuarios {
    @Bean
    List<Usuario> getUsuarios() {
//		return Arrays.asList(
//				new Usuario("Juan", "jioh", "123456"),
//				new Usuario("Marcelo", "mtoro", "123456"),
//				new Usuario("Jonathan", "jcortes", "123456")
//				);
    	List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Juan", "jioh", "123456"));
		usuarios.add(new Usuario("Marcelo", "mtoro", "123456"));
		usuarios.add(new Usuario("Jonathan", "jcortes", "123456"));
	
		return usuarios;
	}
}
