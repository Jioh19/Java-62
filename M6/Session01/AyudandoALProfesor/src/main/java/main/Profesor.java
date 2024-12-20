package main;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Profesor {
	ICalculadora calculadora;
	ICalculadora calculadora2;
	ICalculadora calculadora3;
	
	public void mostrarAlumnosConPromedios() {
		System.out.println("Notas Calculadora 1");
		calculadora.calularPromedios().forEach((alumno) -> {
			System.out.println(alumno.getNombre() + ": " + alumno.getPromedio());
		});
		System.out.println("\n\nNotas Calculadora 2");
		calculadora2.calularPromedios().forEach((alumno) -> {
			System.out.println(alumno.getNombre() + ": " + alumno.getPromedio());
		});
		System.out.println("\n\nNotas Calculadora 3");
		calculadora3.calularPromedios().forEach((alumno) -> {
			System.out.println(alumno.getNombre() + ": " + alumno.getPromedio());
		});
	}
}
