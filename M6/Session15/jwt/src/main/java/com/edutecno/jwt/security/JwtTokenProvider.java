package com.edutecno.jwt.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.edutecno.jwt.model.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {

	@Value("$(security.jwt.token.secret-key)")
	private String secretKey;

//	@Value("$(security.jwt.token.expire-lenght)")
	private long validityInMilliseconds = 3600000;

	private SecretKey key;

	@Autowired
	UserDetailsService userDetailsService;

	@PostConstruct
	protected void init() {
		byte[] keyBytes = Base64.getDecoder().decode(Base64.getEncoder().encodeToString(secretKey.getBytes()));
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	public String createToken(String username, Set<Role> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles.stream().map(Role::getAuthority).collect(Collectors.toList()));

		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);

		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	public Authentication getAuthentication(String token) {
		String username = getUsername(token);
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

	}

	private String getUsername(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;

	}

	public boolean validateToken(String token){
		try{
			Jws<Claims> claims = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token);
			return !claims.getBody().getExpiration().before(new Date());
		} catch (JwtException e) {
			log.error("JWT token invalido o expirado: {}", e.getMessage());
		}
		return false;
	}

}
