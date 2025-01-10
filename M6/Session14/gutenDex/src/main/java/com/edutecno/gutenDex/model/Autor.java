package com.edutecno.gutenDex.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
	@Id
	private String name;
	private int fechaDeNacimiento;
	private int fechaDeDeceso;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Libro> libros;
}
