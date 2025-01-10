package com.edutecno.gutenDex.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="libros")
public class Libro {
	@Id
	private int id;
	private String title;
	private int descaregas;
	@ManyToMany(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Autor> autores;
}
