package com.edutecno.bancoSpring.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CUENTAS")
@Data
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer saldo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_RUT", nullable = false)
	private Cliente cliente;
	

	@OneToMany(mappedBy = "transferencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transferencia> transferencias;
}
