package com.edutecno;

public class Main {
	public static void main(String[] args) {
		//let nombre = "Juan"; esto es javascript
		String nombre = "Juan";
		int edad = 42; // tipo primitivo 32 bits
		Integer miEdad = 42; // es el int objeto
		long numeroLargo = 12345678123923456l; // numero entero de 64bits
		Long numeroObj = 1234564789748964l;
		float numeroflot = 3.14f; //numero de tipo flotante de 32bits
		Float numeroflotObj = 3.14f;
		double numerodouble = 3.1415789453132; //numero flotante de 64bits
		Double numerodoubleObk = 3.14151564765132; 
		
		/**
		 * Recomendacion!!! Utilizen int/Integer, double/Double
		 */
		
		System.out.println("Mi nombre es " + nombre + " y mi edad es " + edad +
				" y mi edad en objeto es " + miEdad);
		
		boolean verdadero = true;
		boolean falso = false;
		Boolean verdaderoObj = true;
		//nombre[2] ='j'; // El String es inmutable
		char caracter = 'A';
		Character cara = 'a';
		
		double resultado = 0.1+0.2;
		System.out.println(resultado);
		
		int numero1 = 55;
		double numero3 = 55.555;
		String numero2 = "25";
		int resultado3 = numero1+ (int)numero3;
		String resultado1 = numero1 + numero2;
		System.out.println(numero1 + numero2);
		
		var cosa = 123456465; // trata de adivinar el tipo, pero no lo recomiendo. Aprendan a usar tipos
		System.out.println(numero1 + " "+ numero2 +" "+numero3);
		
		
	}
}
