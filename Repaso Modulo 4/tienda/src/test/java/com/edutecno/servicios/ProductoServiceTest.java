package com.edutecno.servicios;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import javax.management.InstanceAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.edutecno.modelos.Categoria;
import com.edutecno.modelos.Producto;
import com.edutecno.modelos.Talla;

public class ProductoServiceTest {
    
    private ProductoService productoService;
    private final InputStream systemIn = System.in;

    @BeforeEach
    public void setUp() {
        productoService = new ProductoService();
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testAgregarProductoExitoso() throws InstanceAlreadyExistsException {
        // Simular entrada del usuario
        String input = "001\nProducto Test\nHOMBRE\nS\n1000.0\n10\n";
        provideInput(input);

        // Ejecutar el método
        productoService.agregarProducto();

        // Verificar que el producto fue agregado correctamente
        Producto producto = productoService.obtenerProducto("001");
        assertEquals("001", producto.getCodigo());
        assertEquals("Producto Test", producto.getNombre());
        assertEquals(Categoria.HOMBRE, producto.getCategoria());
        assertEquals(Talla.S, producto.getTalla());
        assertEquals(1000.0, producto.getPrecio(), 0.001);
        assertEquals(10, producto.getStock());
    }

    @Test
    public void testAgregarProductoCodigoPreexistente() throws InstanceAlreadyExistsException {
        // Agregar primer producto
        String input1 = "001\nProducto Test 1\nMUJER\nS\n1000.0\n10\n";
        provideInput(input1);
        productoService.agregarProducto();

        // Intentar agregar segundo producto con mismo código
        String input2 = "001\nProducto Test 2\nROPA\nM\n2000.0\n20\n";
        provideInput(input2);
        assertThrows(InstanceAlreadyExistsException.class, () -> {
        	productoService.agregarProducto();
        	});
       
    }

    @Test
    public void testAgregarProductoPrecioInvalido() throws InputMismatchException {
        // Simular entrada inválida para el precio
        String input = "001\nProducto Test\nHOMBRE\nS\nprecioInvalido\n10\n";
        provideInput(input);
        assertThrows(InputMismatchException.class, () -> {
        	productoService.agregarProducto();
        });
    }

    @Test
    public void testAgregarProductoCategoriaInvalida() throws IllegalArgumentException {
        // Simular entrada con categoría inválida
        String input = "001\nProducto Test\nCATEGORIA_INVALIDA\nS\n1000.0\n10\n";
        provideInput(input);
        assertThrows(IllegalArgumentException.class, () -> {
        	productoService.agregarProducto();        	
        });
    }


    @Test
    public void testCargarYGuardarProductos() {
        // Agregar algunos productos
        String input = "001\nProducto Test\nHOMBRE\nXL\n1000.0\n10\n";
        provideInput(input);
        
        try {
            productoService.agregarProducto();
            
            // Guardar productos
            productoService.guardarProductos();
            
            // Crear nueva instancia de ProductoService
            ProductoService nuevoService = new ProductoService();
            
            // Cargar productos
            nuevoService.cargarProductos();
            
            // Verificar que los productos se cargaron correctamente
            Producto producto = nuevoService.obtenerProducto("001");
            assertEquals("001", producto.getCodigo());
            assertEquals("Producto Test", producto.getNombre());
            
        } catch (InstanceAlreadyExistsException e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }
}
