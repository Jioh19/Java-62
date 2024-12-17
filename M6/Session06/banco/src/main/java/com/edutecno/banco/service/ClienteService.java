package com.edutecno.banco.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.banco.model.Cliente;
import com.edutecno.banco.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	List<Cliente> clientes;
	@Autowired 
	ClienteRepository clienteRepository;
	
	public Map<String, String> validarDatos(Cliente cliente) {
		Map<String, String> errores = new HashMap<>();

		if (!cliente.getRut().matches("^\\d{1,2}\\.?\\d{3}\\.?\\d{3}-[0-9kK]$")) {
			errores.put("rut", "Ingrese un rut válido");
		} else if (cliente.getRut().trim().length() < 8) {
			errores.put("rut", "El rut debe tener al menos 9 carácteres");
		}

//		if (cliente.getNombre() == null || cliente.getNombre().trim() == "") {
//			errores.put("nombre", "Ingrese un nombre válido");
//		} else if (cliente.getNombre().trim().length() < 2) {
//			errores.put("nombre", "El nombre debe tener al menos 3 carácteres");
//		}
		if (!cliente.getNombre().matches("^[a-zA-Z]+$")) {
			errores.put("nombre", "Ingrese un nombre válido");
		} else if (cliente.getNombre().trim().length() < 2) {
			errores.put("nombre", "El nombre debe tener al menos 3 carácteres");
		}

		if (cliente.getApellido() == null || cliente.getApellido().trim() == "") {
			errores.put("apellido", "Ingrese un apellido válido");
		} else if (cliente.getApellido().trim().length() < 1) {
			errores.put("apellido", "El apellido debe tener al menos 3 carácteres");
		}

//		if (cliente.getUsername() == null || cliente.getUsername().trim() == "") {
//			errores.put("username", "Ingrese un username válido");
//		}
//		
		if (!cliente.getUsername().matches("^[a-zA-Z0-9]+$")) {
			errores.put("username", "Ingrese un username válido");
		} else if (clientes.stream().anyMatch(c -> c.getUsername().equals(cliente.getUsername()))) {
			errores.put("username", "Username ya utilizado");
		}

		if (!cliente.getPassword().matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{10,}$")) {
			errores.put("password", "Ingrese un password válido");
		}
		return errores;
	}
	
	public void ingresoInicial() {
		for(Cliente cliente: clientes) {
			clienteRepository.save(cliente);
		}
	}
	
	public List<Cliente> obtenerTodos() {
		List<Cliente> misClientes = clienteRepository.findAll();
		return misClientes;
	}
	
	public void agregarCliente(Cliente cliente ) {
		clienteRepository.save(cliente);
	}

	public Cliente obtenerPorRut(String rut) {
		return clienteRepository.findByRut(rut);
	}
}
