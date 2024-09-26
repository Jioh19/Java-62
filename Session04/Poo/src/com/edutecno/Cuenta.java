package com.edutecno;

public class Cuenta {
	private String numeroCuenta;
	private Integer saldo;
	private Persona persona;
	public Cuenta(String numeroCuenta, Integer saldo, Persona persona) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.persona = persona;
	}
	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	/**
	 * @return the saldo
	 */
	public Integer getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", persona=" + persona + "]";
	} 
	
	
	
}
