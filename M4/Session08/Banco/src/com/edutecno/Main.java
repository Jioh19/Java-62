package com.edutecno;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Cliente juan = new Cliente("Juan", "12345");

		Cuenta cta = crearCuenta(juan, "123456");
		Cuenta[] cuentas = {cta, null, null, null, null};
		juan.setCuentas(cuentas);
		for(Cuenta cuenta: juan.getCuentas()) {
			if(cuenta != null) {
				cuenta.depositar(1000000);				
			}
		}
		System.out.println(juan);
	}
	
	public static Cuenta crearCuenta(Cliente cliente, String numCuenta) {
		Cuenta cuenta;
		
		String menu = """
				**************************************
				* Seleccione tipo de cuenta a crear  *
				**************************************
				* 1- Cuenta corriente                *
				* 2- Cuenta Rut                      *
				**************************************""";
		System.out.println(menu);
		Scanner sc = new Scanner(System.in);
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1: {
			cuenta = new CuentaCorriente(numCuenta, cliente);
			break;
			}
		case 2: {
			cuenta = new CuentaRut(numCuenta, cliente);
			break;
		}
		default:
			System.out.println("Valor inválido");
			cuenta = null;
		}
		return cuenta;
	}
	
}
