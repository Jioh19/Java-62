package com.edutecno.direccionandoRol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.direccionandoRol.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	Users findByEmail(String email);
}
