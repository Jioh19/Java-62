package main;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Calculadora2 implements ICalculadora{

	List<Alumno> alumnos;
	@Override
	public List<Alumno> calularPromedios() {
		int total = 0;
		int notaSuperior = 0;
		for(Alumno alumno: alumnos) {
			for(Integer nota: alumno.getNotas()) {
				if(nota >= 3) {
					total += nota;
					++notaSuperior;
				}
			}
			alumno.setPromedio((float)total / notaSuperior);
		}
		
		return alumnos;
	}

}
