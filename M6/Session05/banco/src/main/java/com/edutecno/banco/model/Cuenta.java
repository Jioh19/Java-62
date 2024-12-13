package com.edutecno.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cuenta {
	private int id;
	private int saldo;
	private Cliente cliente;
	
}
