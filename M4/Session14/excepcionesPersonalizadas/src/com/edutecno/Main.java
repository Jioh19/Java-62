package com.edutecno;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws PersonaExcepcion {
		// TODO Auto-generated method stub
		Persona juan = new Persona();
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre");
		String nombre = sc.next();
		juan.setNombre(nombre);
		System.out.println("Ingrese el rut");
		String rut = sc.next();
		juan.setRut(rut);
		
		int intento = 3;
		while(true ) {
			
			try {
				System.out.println("Ingrese el apellido");
				String apellido = sc.next();
				juan.setApellido(apellido);
				System.out.println("Ingrese edad");
				int edad = sc.nextInt();
				juan.setEdad(edad);
				break;
			} catch (PersonaExcepcion e) {
				System.out.println(e.getMessage() + " " + e);
				if(--intento == 0) {
					System.out.println("Cantidad de intentos sobrepasada!!!");
					throw new PersonaExcepcion("Bloquear por payaso!!");
				}
			} catch (PersonaUncheckedExcepcion e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		System.out.println(juan);
	}

}
