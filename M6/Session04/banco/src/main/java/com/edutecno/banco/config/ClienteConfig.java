package com.edutecno.banco.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edutecno.banco.model.Cliente;

@Configuration
public class ClienteConfig {
	@Bean
	List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente("Juan", "Oh", "15335679", "jioh", "pass"));
		clientes.add(new Cliente("Marcelo", "Toro", "18574861", "mtoro", "123456"));
		clientes.add(new Cliente("Ratanaz", "Elgato", "4564611", "ratan", "miaw"));
		return clientes;
	}
}
