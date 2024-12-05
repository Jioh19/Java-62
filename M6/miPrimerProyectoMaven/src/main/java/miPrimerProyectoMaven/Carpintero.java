package miPrimerProyectoMaven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Carpintero {
	private String nombre;
	private HerramientaParaCortarMadera herramienta;
}
