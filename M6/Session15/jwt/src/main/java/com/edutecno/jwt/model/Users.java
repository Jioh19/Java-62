package com.edutecno.jwt.model;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	private Long idUser;
	private String username;
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Role> roles;
}
