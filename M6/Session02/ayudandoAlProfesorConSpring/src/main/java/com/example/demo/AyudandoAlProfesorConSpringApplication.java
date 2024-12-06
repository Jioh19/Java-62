package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@EnableAutoConfiguration, @ComponentScan, @SpringBootConfiguration
public class AyudandoAlProfesorConSpringApplication implements CommandLineRunner{

	@Autowired
	Profesor profesor;
	public static void main(String[] args) {
		SpringApplication.run(AyudandoAlProfesorConSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		profesor.mostrarAlumnosConPromedio();
	}

}
