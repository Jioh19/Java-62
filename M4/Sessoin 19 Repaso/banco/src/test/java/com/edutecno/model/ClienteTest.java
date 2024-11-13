package com.edutecno.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ClienteTest {
	private static Cliente cliente;
	private static final String NOMBRE = "Juan";
	private static final String APELLIDO = "Oh";
	private static final String RUT = "123456";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cliente = new Cliente(NOMBRE, APELLIDO, RUT);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		cliente = null;
	}

	// Usar el "assertAll" en caso de que si hay error, se indiquen todas las
	// aserciones
	// fallidas
	@Test
	void testCreacionCliente() {
		assertAll("Agreupación de asserts de la creación cliente", () -> assertNotNull(cliente, "El cliente es nulo"),
				() -> assertEquals(cliente.getNombre(), NOMBRE, "El nombre es distinto" + NOMBRE),
				() -> assertEquals(cliente.getApellido(), APELLIDO, "El apellido es distinto"),
				() -> assertEquals(cliente.getRut(), RUT, "El rut no corresponde"),
				() -> assertTrue(cliente.getCuentas().isEmpty(), "La lista de cuentas no esta vacía"));
	}

	//Test de agregar cuenta deberia de ir en ServicioCliente, pero por temas de tiempo 
	//se colocó acá.
	@Test
	void testAgregarCuenta() {
		Cuenta cuenta = new CuentaCorriente("001", cliente);
		cliente.getCuentas().add(cuenta);

		assertAll("Agrupación de aserciones de cliente cuenta",
				() -> assertFalse(cliente.getCuentas().isEmpty(), 
						"La lista no debería de estar vacía"),
				() -> assertEquals(cliente.getCuentas().size(), 
						1, "Debería de haber 1 cuenta"),
				() -> assertEquals(cliente.getCuentas().get(0), 
						cuenta, "Deberia de ser la misma cuenta")

		);
	}

}
