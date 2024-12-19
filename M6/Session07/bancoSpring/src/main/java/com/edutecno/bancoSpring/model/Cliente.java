package com.edutecno.bancoSpring.model;

import lombok.Data;


@Data
public class Cliente {

	private Integer id;
	private String rut;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	
	

}
