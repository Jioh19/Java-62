package com.edutecno.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/clientes/listado_productos")
						.hasAuthority("CLIENT").requestMatchers("/productos/listar").hasAuthority("ADMIN")
						.requestMatchers("/productos/agregar_producto").hasAuthority("ADMIN")
						.requestMatchers("/productos/eliminar/{id}").hasAuthority("ADMIN")
						.requestMatchers("/productos/modificar_producto").hasAuthority("ADMIN")
						.requestMatchers("/api/v1/users/signup").permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").usernameParameter("username").passwordParameter("password"))
				.exceptionHandling(exception -> exception.accessDeniedPage("/prohibido"));

		return http.build();
	}

}
