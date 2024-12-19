package com.edutecno.bancoSpring.model;

import lombok.Data;


@Data
public class Transferencia {
	private Integer id;
	private Cuenta origen;
	private Cuenta destino;
	private Integer monto;
}
