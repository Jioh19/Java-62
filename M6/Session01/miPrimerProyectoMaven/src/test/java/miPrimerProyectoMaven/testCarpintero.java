package miPrimerProyectoMaven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testCarpintero {

	@Test
	void test() {
		Carpintero carpintero = new Carpintero();
		carpintero.setNombre("Juan");
		carpintero.setHerramienta(new SierraElectrica());
		carpintero.getHerramienta().cortar();
		assertEquals("Juan", carpintero.getNombre());
	}

}