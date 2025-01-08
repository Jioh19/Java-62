package com.edutecno.springApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.springApi.service.DigimonService;

import com.edutecno.springApi.service.DigimonService;

@SpringBootApplication
public class SpringApiApplication implements CommandLineRunner{

	@Autowired
	DigimonService service;
	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		service.findAll().getContent().forEach(System.out::println);
		System.out.println(service.findById(38));
	}

}
