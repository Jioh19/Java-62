package com.edutecno;

public class Main {
	public static void main(String[] args) {
		Cliente juan = new Cliente("Juan", "12345");
		CuentaCorriente cc = new CuentaCorriente("1111", juan);
		CuentaRut cr = new CuentaRut("1112", juan);
		cc.depositar(123456);
		if(!cr.depositar(4000000)) {
			System.out.println("Hubo problemas depositando");
		}
		System.out.println(cr);
	}
	
}
