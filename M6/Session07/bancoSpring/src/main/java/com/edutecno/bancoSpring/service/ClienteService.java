package com.edutecno.bancoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.bancoSpring.dao.ClienteRepository;
import com.edutecno.bancoSpring.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> obtenerTodos() {
		return clienteRepository.findAll();
	}
	
	public void agregarCliente(Cliente cliente) {
		System.out.println(cliente);
		clienteRepository.save(cliente);
	}
	
	public Cliente encontrarPorRut(String rut) {
		return clienteRepository.findByRut(rut);
	}
}
