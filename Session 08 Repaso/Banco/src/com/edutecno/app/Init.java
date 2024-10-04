package com.edutecno.app;

import com.edutecno.cliente.Cliente;
import com.edutecno.cliente.Nivel;
import com.edutecno.cuenta.Cuenta;
import com.edutecno.cuenta.CuentaCorriente;

public final class Init {

	public static Cliente[] cargarClientes() {
		Cliente[] clientes = new Cliente[10];
		Cliente juan = new Cliente("Juan", "Oh", "123456789", Nivel.VIP);
		Cuenta cc = new CuentaCorriente("1111", juan);
		juan.addCuenta(cc);
		clientes[0] = juan;
		return clientes;
		
	}
}
