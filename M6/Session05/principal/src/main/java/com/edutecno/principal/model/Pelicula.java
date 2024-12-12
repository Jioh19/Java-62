package com.edutecno.principal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pelicula {
	private int id;
	private String titulo;
	private String director;
	private int anio;
	private int duracion;
}
