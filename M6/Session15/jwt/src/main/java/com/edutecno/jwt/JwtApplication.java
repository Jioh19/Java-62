package com.edutecno.jwt;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.jwt.model.Role;
import com.edutecno.jwt.model.Users;
import com.edutecno.jwt.service.UsersService;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner{

	@Autowired
	UsersService service;
	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		service.save(new Users(1l, "jioh" , "123", new HashSet<Role>()));
		service.save(new Users(2l, "mtoro" , "123456", new HashSet<Role>()));
	}

}
