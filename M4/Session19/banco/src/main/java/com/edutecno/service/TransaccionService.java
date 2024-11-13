package com.edutecno.service;

import java.util.List;

import com.edutecno.model.Transaccion;

public class TransaccionService {
	private List<Transaccion> transacciones;

	public TransaccionService(List<Transaccion> transacciones) {
		super();
		this.transacciones = transacciones;
	}
	
	public void addTransaccion(Transaccion transaccion) {
		transacciones.add(transaccion);
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}
	
	
}
