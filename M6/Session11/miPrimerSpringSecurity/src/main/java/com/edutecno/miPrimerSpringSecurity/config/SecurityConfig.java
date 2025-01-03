package com.edutecno.miPrimerSpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.edutecno.miPrimerSpringSecurity.service.UserService;

@Configuration
public class SecurityConfig {

	@Autowired
	UserService userService;
	
//	@Autowired
//	BCryptPasswordEncoder passwordE;
//	
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
    
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    
   // Version para Java 8
//    public void configure(HttpSecurity http) throws Exception {
//    	http.authorizeHttpRequests()
//    	.anyRequest()
//    	.authenticated()
//    	.and()
//    	.httpBasic();
//    }
    
    // Version para Java 17
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
    	.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
    	.httpBasic(Customizer.withDefaults());
    	return http.build();
    }
    
}
