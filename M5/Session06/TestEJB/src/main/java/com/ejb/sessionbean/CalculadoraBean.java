package com.ejb.sessionbean;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class CalculadoraBean {

	public CalculadoraBean() {
		super();
	}

	public double add(double x, double y) {
		return x + y;
	}
	
	public double substract(double x, double y) {
		return x-y;
	}
	
	public double multiply(double x, double y) {
		return x*y;
	}
	
	public double division(double x, double y) {
		return x/y;
	}
}
