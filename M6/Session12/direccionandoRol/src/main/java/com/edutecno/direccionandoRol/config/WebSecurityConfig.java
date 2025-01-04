package com.edutecno.direccionandoRol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	private final AuthenticationSuccessHandler authenticationSuccessHandler;
	private final UserDetailsService userService;
	
	@Autowired
	WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler,
			UserDetailsService userDetailsService) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
		this.userService = userDetailsService;
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
		// Autorizaciones
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/admin/**").hasAuthority("ADMIN")
				.requestMatchers("/client/**").hasAuthority("CLIENT")
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated())
		// Login
		.formLogin(form -> form
				.loginPage("/login")
				.successHandler(authenticationSuccessHandler)
				.failureUrl("/login?error=true")
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll())
		
		.exceptionHandling(ex -> ex
				.accessDeniedPage("/prohibido"));
		
		return http.build();
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
