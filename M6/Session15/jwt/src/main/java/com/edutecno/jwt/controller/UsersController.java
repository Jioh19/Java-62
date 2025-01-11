package com.edutecno.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edutecno.jwt.model.Users;
import com.edutecno.jwt.service.UsersService;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

	@Autowired
	UsersService usersService;
	@GetMapping("/lista")
	@ResponseStatus(HttpStatus.OK)
	public List<Users> findAll() {
		return usersService.findAll();
	}
	
	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public String signup(@RequestBody Users users) {
	return usersService.signup(users);
	}
}
