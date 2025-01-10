package com.edutecno.consumoApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edutecno.consumoApi.dto.Usuario;

@Service
public class UsuarioService {

	@Autowired
	RestTemplate restTemplate;

	private Usuario usuario;
	private HttpEntity<Usuario> request = new HttpEntity<>(usuario);
	private String ruta;

	public List<Usuario> findAll() {
		ruta = "http://localhost:8080/api/v1/usuarios/lista_usuarios";
		ResponseEntity<List<Usuario>> response = restTemplate.exchange(ruta, HttpMethod.GET, request,
				new ParameterizedTypeReference<List<Usuario>>() {
				});
		return response.getBody();
	}

	public void crearUsuario(Usuario usuario) {
		ruta = "http://localhost:8080/api/v1/usuarios/nuevo_usuario";
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		restTemplate.postForEntity(ruta, request, String.class);
	}
	
	public void modificar(Usuario usuario) {
		ruta = "http://localhost:8080/api/v1/usuarios/mnodificar_usuario";
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		restTemplate.put(ruta, request, String.class);
	}
	
	public void eliminar(Integer id) {
		ruta = "http://localhost:8080/api/v1/usuarios/delete_usuario/";
		restTemplate.delete(ruta + id);
	}
}
