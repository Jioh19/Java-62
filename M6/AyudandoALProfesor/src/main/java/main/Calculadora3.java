package main;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Calculadora3 implements ICalculadora{

	List<Alumno> alumnos;
	@Override
	public List<Alumno> calularPromedios() {

		for(Alumno alumno: alumnos) {
			int total = 0;
			alumno.getNotas().sort(null);
			System.out.println(alumno.getNotas());
			for(int i = 1; i < alumno.getNotas().size() - 1; i++) {
				total += alumno.getNotas().get(i);
			}
			if(alumno.getNotas().size() <= 2) {
				alumno.setPromedio(0f);
			} else {
				System.out.println(total + " " + (alumno.getNotas().size() - 2));
				alumno.setPromedio((float) (total / (alumno.getNotas().size() - 2)));
				
			}
		}
		
		return alumnos;
	}
}
