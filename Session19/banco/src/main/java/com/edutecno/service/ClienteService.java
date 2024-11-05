package com.edutecno.service;

import java.util.List;

import com.edutecno.excepciones.ClienteException;
import com.edutecno.model.Cliente;

public class ClienteService {
	private List<Cliente> clientes;

	public ClienteService(List<Cliente> clientes) {
		super();
		this.clientes = clientes;
	} 
	
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void setCliente(int index, Cliente cliente) {
		clientes.set(index, cliente);
	}
	
	public void removeCliente(int index) {
		clientes.remove(index);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public Cliente getCliente(int index) throws ClienteException {
		
		Cliente cliente = clientes.get(index);
		if(cliente == null) {
			throw new ClienteException("Error, cliente no encontrado");
		}
		return cliente;
	}
	
}
