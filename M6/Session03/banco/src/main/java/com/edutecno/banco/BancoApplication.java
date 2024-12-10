package com.edutecno.banco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.banco.model.Cliente;

@SpringBootApplication
public class BancoApplication implements CommandLineRunner{

	@Autowired
	List<Cliente> clientes;
	
	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		clientes.forEach(System.out::println);
	}

}
