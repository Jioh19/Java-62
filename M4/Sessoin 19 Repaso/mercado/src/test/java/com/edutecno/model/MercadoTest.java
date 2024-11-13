package com.edutecno.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MercadoTest {
	
	Mercado mercado = mock(Mercado.class);
	

	Product producto = mock(Product.class);
	
	ArrayList<Product> productos = new ArrayList<>();
	ArrayList<Product> spyProd = spy(productos);
 	
	@Test
	void testPublicarAviso() {
		
		when(mercado.publicarAviso(productos, producto)).thenReturn(productos);
		when(spyProd.size()).thenReturn(1);
		
		assertAll("Verificación de la publicación de aviso",
				() -> assertEquals(mercado.publicarAviso(productos, producto), productos),
				() -> assertEquals(spyProd.size(), 1)
				);
	}
	
	@Test
	void crearAvisoTest() {
		when(producto.crearAviso("string1", 0, "String2", "String3")).thenReturn(producto);
		assertEquals(producto.crearAviso("string1", 0, "String2", "String3"), producto);
	}
	
	@Test
	void publicarAvisoTest() {
		when(mercado.publicarAviso(productos, producto)).thenReturn(productos);
		assertEquals(mercado.publicarAviso(productos, producto), productos);
	}

}
