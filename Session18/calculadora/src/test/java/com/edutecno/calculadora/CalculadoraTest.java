package com.edutecno.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Test para la clase calculadora")

class CalculadoraTest {

	private static Calculadora calcu;
	
	//Ejecuta este método antes de todos los test
	@BeforeAll
	static void setup() {
		calcu = new Calculadora();
	}
	
	//Ejecuta este método antes de cada test
	@BeforeEach
	void uniSetup() {
		calcu = calcu;
	}
	
	
	//Ejecuta este método después de todos los test
	@AfterAll
	static void eliminate() {
		calcu = null;
	}
	
	//Ejecuta este método después de cada test
	@AfterEach
	void uniEliminate() {
		calcu = calcu;
	}
	
	@ParameterizedTest
	@CsvSource({"2, 3, 5", "5, 7, 12", "100, 105, 205", "1, -1, 0"})
	@DisplayName("Test para la suma")
	void testSumar(int a, int b, int expected) {
		int result = calcu.sumar(a, b);
		assertEquals(expected, result, () -> "Aprende a sumar, hubo una diferencia" +" "+ (expected - a - b));
		
	}
	
	@ParameterizedTest
	@CsvSource({"Hola, Chao, HolaChao", "5, 7, 57", "100, 105, 100105", "1, -1, 1-1"})
	@DisplayName("Test para los Strings")
	void testAdjuntar(String a, String b, String expected) {
		String result = calcu.adjuntar(a, b);
		assertEquals(expected, result);
		
	}
	
	@Test 
	void testRestar() {
		int result = calcu.restar(10, 5);
		assertEquals(5, result);
	}

	@Test 
	void testMultiplicar() {
		int result = calcu.multiplicar(5, 7);
		assertEquals(35, result);
	}
	
	@Test 
	void testDividir() {
		int result = calcu.dividir(45, 5);
		assertEquals(9, result);
	}
	
	@Test
	void testDividirPorZero() {
		assertThrows(ArithmeticException.class, () -> {
			calcu.dividir(10, 0);
		});
	}
	
	//Operaciones con double y float, tienen la posibilidad de color un delta para la igualdad "assertEquals"
	@Test
	void testSumaDouble() {
		double result = 0.1 + 0.2;
		assertEquals(0.3, 0.0000000001, result);
	}
	
	@Test
	void login() {
		assertAll("Login de usuario",
				() -> assertEquals("Juan", "Jun", "Nombre de usuario incorrecto"),
				() -> assertEquals("123456", "123456", "Clave incorrecta"));
	}
}
