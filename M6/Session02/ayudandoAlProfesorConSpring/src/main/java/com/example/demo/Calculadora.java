package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component // Este se usa para componentes de clase en Spring
public class Calculadora implements ICalculadora {

	@Autowired
	@Qualifier("getVacia")
	List<Alumno> alumnos;

	@Override
	public List<Alumno> calcularPromedios() {

		for (Alumno alumno : alumnos) {
			int total = 0;
			for(Integer nota: alumno.getNotas()) {
				total += nota;
			}
			alumno.setPromedio((float)(total / alumno.getNotas().size()));
		}
		return alumnos;
	}

}
