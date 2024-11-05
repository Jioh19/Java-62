package com.edutecno.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import com.edutecno.excepciones.CuentaException;
import com.edutecno.model.Cliente;
import com.edutecno.model.Cuenta;
import com.edutecno.model.CuentaCorriente;

class CuentaServiceTestMockito {

	Cuenta c1 = mock(Cuenta.class);
	Cuenta c2 = new CuentaCorriente("123456", mock(Cliente.class));
	Cuenta spyC2 = spy(c2);

	private static CuentaService service;
	private static List<Cuenta> cuentas;

	@BeforeAll
	static void init() {
		cuentas = new ArrayList<>();
		service = new CuentaService(cuentas);
	}

	@Test
	void testDepositar() throws CuentaException {
		when(c1.canDepositar(100.0)).thenReturn(true);
		when(c1.getTransaccionService()).thenReturn(new TransaccionService(new ArrayList<>()));
		boolean result = service.depositar(c1, 100.0);
		assertAll("Deposito a cuenta", () -> assertTrue(c1.canDepositar(100.0)), () -> assertTrue(result));
	}

	@Test
	void testDepositarFracaso() throws CuentaException {
		when(c1.canDepositar(100.0)).thenReturn(true);
		when(c1.getTransaccionService()).thenReturn(new TransaccionService(new ArrayList<>()));
		// when(c1.depositar(100.0)).thenThrows(CuentaException.class);
		doThrow(new CuentaException("No se puede depositar")).when(c1).depositar(100.0);

		assertAll("Deposito a cuenta fracasado", () -> assertTrue(c1.canDepositar(100.0)),
				() -> assertThrows(CuentaException.class, () -> c1.depositar(100.0)));

	}

	@Test
	void testRetirar() {
		//spyC2.canRetirar(200);  retorna false
		assertFalse(spyC2.canRetirar(200));
		when(spyC2.canRetirar(200.0)).thenReturn(true);
		assertTrue(spyC2.canRetirar(200.0));
	}
//
//	@Test
//	void testTransferir() {
//		fail("Not yet implemented");
//	}

	@ParameterizedTest
	@ValueSource(doubles = {100, 200, 300, 400 ,500})
	void testDepositarParametrizado(double deposito) throws CuentaException {
		when(c1.canDepositar(deposito)).thenReturn(true);
		when(c1.getTransaccionService()).thenReturn(new TransaccionService(new ArrayList<>()));
		boolean result = service.depositar(c1, deposito);
		assertAll("Deposito a cuenta", () -> assertTrue(c1.canDepositar(deposito)), () -> assertTrue(result));
	}
	
	@Test
	void testTransferir() throws CuentaException {
		when(c1.canRetirar(100)).thenReturn(true);
		when(spyC2.canDepositar(100)).thenReturn(true);
		when(c1.getTransaccionService()).thenReturn(new TransaccionService(new ArrayList<>()));
		when(spyC2.getTransaccionService()).thenReturn(new TransaccionService(new ArrayList<>()));
		boolean result = service.transferir(c1, spyC2, 100);
		assertAll("Transferencia de c1 a spyC2",
				() -> assertTrue(c1.canRetirar(100)),
				() -> assertTrue(spyC2.canDepositar(100)),
				() -> assertTrue(result)
				);
	}
}
