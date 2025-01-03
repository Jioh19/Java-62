package miPrimerProyecto;

import java.util.List;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	private String rut;
	private LocalDate nacimiento;
	private List<Integer> numeros;
	private int saldo;
}
