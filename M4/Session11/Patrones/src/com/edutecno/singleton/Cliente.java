package com.edutecno.singleton;
// Clase Singleton
public class Cliente {
	//Atributos "static". No es necesario instanciar la clase para usar el atributo
	private static Cliente instance;
	private int numero = 0;

	private Cliente() {
		super();
	}
	
	//Método "static". No es necesario instancias la clase para usar el método
	public static Cliente getCliente() {
		//Si ya existe una instancia se devuelve dicha instancia
		//Si no existe se devuelve una nueva instancia y se devuelve
		if(instance == null) {
			instance = new Cliente();
		}
		
		return instance;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getNumero() {
		return numero;
	}
	
	
	
	
}
