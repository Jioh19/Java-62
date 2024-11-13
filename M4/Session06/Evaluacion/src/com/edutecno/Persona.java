package com.edutecno;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.regex.Pattern;

public class Persona {
	private String user;
	private String password;
	private String nombre;
	private LocalDate fechaNacimiento;
	public Persona(String user, String password, String nombre, LocalDate fechaNacimiento) {
		super();
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public boolean largoPass() {
		if(password.length() >= 10) {
			return true;
		}
		return false;
	}
	
	public boolean mayusPass() {
		int total = 0;
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				total++;
			}
		}
		if(total >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean charaPass() {
		int total = 0;
		for(int i = 0; i < password.length(); i++) {
			if(!Character.isUpperCase(password.charAt(i)) && !Character.isLowerCase(password.charAt(i))) {
				total++;
			}
		}
		if(total >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
 	//.*[A-Z].*[A-Z]
	public boolean regexPass() {
		return Pattern.matches(".*[A-Z].*[A-Z]", password);
	}
	
	public boolean regexCharaPass() {
		return Pattern.matches("(?:.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?1234567890]){3}", password);
	}
	
	public boolean mayor() {
		LocalDate lt = LocalDate.now();
		Period period = Period.between(lt, fechaNacimiento);
		if(period.getYears() >= 18) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Persona [user=" + user + ", password=" + password + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}

	
}
