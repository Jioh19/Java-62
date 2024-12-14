package com.edutecno.controlAgricola.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "sequence_arbol",initialValue = 1, allocationSize = 1, sequenceName ="sequence_arbol")
public class Arbol {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_arbol")
	private Integer id;
	private BigDecimal lng; 
	private BigDecimal lat;
	private BigDecimal altura;
	private BigDecimal radio;
	private String tipoArbol;
	private String tratamiento;
}	
