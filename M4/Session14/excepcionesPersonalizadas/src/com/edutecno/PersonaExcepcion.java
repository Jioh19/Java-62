package com.edutecno;

public class PersonaExcepcion extends Exception{

	private static final long serialVersionUID = 1L;

	public PersonaExcepcion() {
		super();
	}

	public PersonaExcepcion(String message) {
		super(message);
	}

	public PersonaExcepcion(String message, Throwable cause) {
		super(message, cause);
	}

	
}
