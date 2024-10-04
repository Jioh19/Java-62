package com.edutecno.cuenta;

import com.edutecno.cliente.Cliente;

public class CuentaCorriente extends Cuenta{

	public CuentaCorriente(String numero, Cliente cliente) {
		super(numero, cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean depositar(double deposito) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retirar(double retiro) {
		// TODO Auto-generated method stub
		return false;
	}

}
