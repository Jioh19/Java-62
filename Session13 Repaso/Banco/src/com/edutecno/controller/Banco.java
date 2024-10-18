package com.edutecno.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.edutecno.model.Cliente;
import com.edutecno.model.Cuenta;
import com.edutecno.model.CuentaCorriente;
import com.edutecno.service.ClienteService;
import com.edutecno.service.CuentaService;

public class Banco {
	private List<Cliente> clientes;
	private List<Cuenta> cuentas;
	private ClienteService clienteService;
	private CuentaService cuentaService;

	public Banco() {
		super();
		clientes = new ArrayList<>();
		cuentas = new LinkedList<>();
		clienteService = new ClienteService(clientes);
		cuentaService = new CuentaService(cuentas);
	}

	public Cliente registrarCliente(String nombre, String apellido, String rut) {
		Cliente cliente = new Cliente(nombre, apellido, rut);
		clientes.add(cliente);
		return cliente;
	}

	public Cuenta crearCuenta(Cliente cliente) {
		Cuenta cuenta = new CuentaCorriente(String.valueOf(new Random().nextInt(899999) + 100000), cliente);
		cuentas.add(cuenta);
		return cuenta;
	}

	public ClienteService getClienteSerive() {
		return clienteService;
	}

	public CuentaService getCuentaService() {
		return cuentaService;
	}

	@Override
	public String toString() {
		return String.format("Banco [clientes=%s, cuentas=%s]", clientes, cuentas);
	}
	
	
}
