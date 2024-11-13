package com.edutecno.calculadora;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class CalculadoraTest {

	Calculadora calc = mock(Calculadora.class);
	
	@Test
	void testSumar() {
		// Implementamos los stubs
		// Cuando se ejecuta, retorna tal cosa
		when(calc.sumar(5, 5)).thenReturn(10);
		assertEquals(calc.sumar(5, 5), 10);
	}

	@Test
	void testRestar() {
		when(calc.restar(5, 5)).thenReturn(0);
		assertEquals(calc.restar(5, 5), 0);
	}

	@Test
	void testMultiplicar() {
		when(calc.multiplicar(5, 5)).thenReturn(25);
		assertEquals(calc.multiplicar(5, 5), 25);
		verify(calc).multiplicar(5,5);
	}

	@Test
	void testDividir() {
		when(calc.dividir(5, 5)).thenReturn(1);
		//vamos a hacer el stub en caso de division por 0
		when(calc.dividir(5, 0)).thenThrow(new ArithmeticException("Division por 0"));
		
		assertEquals(calc.dividir(5, 5), 1);
		assertThrows(ArithmeticException.class, () -> {
			calc.dividir(5, 0);
		});
		
//		Exception exception = assertThrows(RuntimeException.class, () -> {
//	        Integer.parseInt("1a");
//	    });
//
//	    String expectedMessage = "For input string";
//	    String actualMessage = exception.getMessage();
//
//	    assertTrue(actualMessage.contains(expectedMessage));
	}

}
