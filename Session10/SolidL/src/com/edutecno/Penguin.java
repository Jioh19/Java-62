package com.edutecno;

public class Penguin extends Bird{

	@Override
	public void volar() {
		throw new UnsupportedOperationException("No puedo Volar");
	}
	
}
