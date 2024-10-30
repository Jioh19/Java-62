package com.edutecno.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.edutecno.excepciones.CuentaException;
import com.edutecno.model.Cliente;
import com.edutecno.model.Cuenta;
import com.edutecno.model.CuentaCorriente;
import com.edutecno.model.Transaccion;

class CuentaServiceTest {

	private CuentaService cuentaService;
	private List<Cuenta> cuentas;
	private Cuenta cuenta1;
	private Cuenta cuenta2;
	private static Cliente cliente1;
	private static Cliente cliente2;
	private static double delta;

	// Se hacen cosas ANTES de los test
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cliente1 = new Cliente("Juan", "Oh", "123456");
		cliente2 = new Cliente("Marcelo", "Toro", "987654");
		delta = 0.0001;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		cliente1 = null;
		cliente2 = null;
	}

	// Se hacen cosas ANTES de cada test
	@BeforeEach
	void setUp() throws Exception {
		cuentas = new ArrayList<>();
		cuentaService = new CuentaService(cuentas);
		cuenta1 = new CuentaCorriente("001", cliente1);
		cuenta2 = new CuentaCorriente("002", cliente2);
	}

	@AfterEach
	void tearDown() throws Exception {
		cuentas = null;
		cuentaService = null;
		cuenta1 = null;
		cuenta2 = null;
	}

	@Test
	void testAddCuenta() {
		cuentaService.addCuenta(cuenta1);
		cuentaService.addCuenta(cuenta2);
		assertAll("Acumulación de aserts de addCuenta",
				() -> assertEquals(2, cuentaService.getCuentas().size(),
						"La cantidad de cuenta no concuerda"),
				() -> assertEquals(cuenta2, cuentaService.getCuentas().get(1), 
						"No son la misma cuenta ")	
				);
	}

	@Test
	void testSetCuenta() {
		cuentaService.addCuenta(cuenta1);
		Cuenta nuevaCuenta = new CuentaCorriente("003", cliente1);
		cuentaService.setCuenta(0, nuevaCuenta);
		assertEquals(cuentaService.getCuentas().get(0), nuevaCuenta, "No son cuentas iguales");
	}

	@Test
	void testRemoveCuenta() {
		cuentaService.addCuenta(cuenta1);
		cuentaService.addCuenta(cuenta2);
		cuentaService.removeCuenta(0);
		assertEquals(1, cuentaService.getCuentas().size(), "No concuerda la cantidad de cuentas");
	}
	
	@Test
	void testDepositarExitoso() throws CuentaException {
		double monto = 500;
		boolean resultado = cuentaService.depositar(cuenta1, monto);
		assertTrue(resultado);
		assertEquals(monto, cuenta1.getSaldo(), delta, "Los montos no son iguales");
		
		//Verificar si se crean correctamente las transacciones
		List<Transaccion> transacciones = 
				cuenta1.getTransaccionService().getTransacciones();
		assertEquals(1, transacciones.size(), "La cantidad de transacciones es incorrecta");
	}
	
	//Ya que probamos el caso de el deposito exitoso, también probaremos el deposito 
	//fracasado.
	@Test
	void testDepositarFracaso() throws CuentaException {
		double monto = 100_000_000; // 100000000, son lo mismo, pero es más fácil de leer
		boolean resultado = cuentaService.depositar(cuenta1, monto);
		assertFalse(resultado);
		assertNotEquals(monto, cuenta1.getSaldo(), delta, "Los montos son iguales");
		
		//Verificar si se crean correctamente las transacciones
		List<Transaccion> transacciones = 
				cuenta1.getTransaccionService().getTransacciones();
		assertNotEquals(1, transacciones.size(), "La cantidad de transacciones es incorrecta");
		
	}

}
