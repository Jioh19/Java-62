package com.edutecno.springSec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer precio;
}
