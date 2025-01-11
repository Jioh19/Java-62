package com.edutecno.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.jwt.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	boolean existsByUsername(String username);
	Users findByUsername(String username);
}
