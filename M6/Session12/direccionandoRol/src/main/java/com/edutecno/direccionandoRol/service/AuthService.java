package com.edutecno.direccionandoRol.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edutecno.direccionandoRol.model.Users;
import com.edutecno.direccionandoRol.repository.UsersRepository;

@Service
public class AuthService implements UserDetailsService{

	@Autowired
	UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users = repository.findByEmail(username);
		if(users == null) 
			throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		authorities.add(new SimpleGrantedAuthority(users.getRole()));
		return new User(users.getEmail(), users.getPassword(), authorities);
	}
	
}
