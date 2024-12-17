package com.edutecno.bancoSpring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUENTA_ID", nullable = false)
	private Cuenta origen;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUENTA_ID", nullable = false)
	private Cuenta destino;
	private Integer monto;
}
