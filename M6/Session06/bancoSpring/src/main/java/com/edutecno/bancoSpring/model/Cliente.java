package com.edutecno.bancoSpring.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "CLIENTES")
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "RUT", nullable = false)
	private String rut;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	private String apellido;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<Cuenta> cuentas;
	

}
