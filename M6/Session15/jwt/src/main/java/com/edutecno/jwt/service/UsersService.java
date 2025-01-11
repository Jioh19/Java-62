package com.edutecno.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edutecno.jwt.model.Users;
import com.edutecno.jwt.repository.UsersRepository;
import com.edutecno.jwt.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService implements IUsers{
	
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	//private final AuthenticationManager authenticationManager;
	

	@Override
	public List<Users> findAll() {
		return usersRepository.findAll();
	}
	
	public void save(Users user) {
		usersRepository.save(user);
	}
	
	//PENDIENTE A CORREGIR!@!!
//	public String singin(String username, String password) {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//			log.info("Logueando con el usuario: {}", username);
//			
//			if(usersRepository.existsByUsername(username)) {
//				Users user = usersRepository.findByUsername(username);
//				return jwtTokenProvider.createToken(username, user.getRoles());	
//			} else {
//				return "";
//			}
//		} catch (Exception e) {
//			System.out.println("Ingresaste incorrectamente el password o el username");
//		}
//		return "";
//	}
	
	public String signup(Users user) {
		if(!usersRepository.existsByUsername(user.getUsername())) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
		return
		jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
		}else{
			System.out.println("El usuario ya existe");
		}
		return null;
		}
	
	
	
}
