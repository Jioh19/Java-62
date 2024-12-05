package main;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
	private String rut;
	private String nombre;
	private List<Integer> notas;
	private Float promedio;
}
