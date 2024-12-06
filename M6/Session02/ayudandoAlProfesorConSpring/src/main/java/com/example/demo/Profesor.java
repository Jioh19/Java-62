package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Component //Una de las etiquetas mas basicas para que sea manejada por Spring
public class Profesor {
	
	@Autowired
	Calculadora calculadora;
	
	public void mostrarAlumnosConPromedio() {
		calculadora.calcularPromedios().forEach(System.out::println);
	}
}
