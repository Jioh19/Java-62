package com.edutecno.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.edutecno.excepciones.CuentaException;
import com.edutecno.model.Cuenta;
import com.edutecno.model.CuentaCorriente;

class CuentaServiceTestMockito {
	
	Cuenta c1 = mock(CuentaCorriente.class);
	Cuenta c2 = new CuentaCorriente("123456", mock(Cliente.class));
	
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
		assertAll(
				"Deposito a cuenta",
				() -> assertTrue(c1.canDepositar(100.0)),
				() -> assertTrue(result)
				);	
	}
	
	@Test
	void testDepositarFracaso() throws CuentaException {
		when(c1.canDepositar(100.0)).thenReturn(true);
		when(c1.getTransaccionService()).thenReturn(new TransaccionService(new ArrayList<>()));
		//when(c1.depositar(100.0)).thenThrows(CuentaException.class);
		doThrow(new CuentaException("No se puede depositar")).when(c1).depositar(100.0);
		try {
			boolean result = service.depositar(c1, 100.0);			
			assertAll(
					"Deposito a cuenta fracasado",
					() -> assertTrue(c1.canDepositar(100.0)),
					() -> assertFalse(result)
					);	
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

//	@Test
//	void testRetirar() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTransferir() {
//		fail("Not yet implemented");
//	}

}
