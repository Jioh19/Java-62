package com.edutecno;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hola mundo");
		
		Persona yo = new Persona();
		
		yo.setNombre("Juan");
		yo.setApellido("Oh");
		yo.setEdad(42);
		
		//System.out.println(yo.nombre + " " + yo.apellido + " " + yo.edad);
		//System.out.println(yo);
		//yo.caminar();
		
		Cuenta cuenta = new Cuenta("123456", 100000, yo);
		
		yo.setCuenta(cuenta);
//		System.out.println("Titular: " + cuenta.getPersona().getNombre());
//		System.out.println("Saldo: " + cuenta.getSaldo());
		System.out.println(cuenta);
	}

}
