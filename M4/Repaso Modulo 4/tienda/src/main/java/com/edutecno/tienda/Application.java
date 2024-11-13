package com.edutecno.tienda;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.edutecno.modelos.Categoria;
import com.edutecno.modelos.Cliente;
import com.edutecno.modelos.Producto;
import com.edutecno.modelos.Talla;
import com.edutecno.modelos.Venta;
import com.edutecno.servicios.ProductoService;
import com.edutecno.utils.Util;
import com.edutecno.vistas.Menu;

public class Application {

    public static void main(String[] args) {
        Menu menu = new Menu();
        
        menu.iniciarMenu();
//        Map<String, Producto> productos = new HashMap<>(); 
//        Producto p1 = new Producto("001", "Camisa", Categoria.HOMBRE, Talla.M, 8000.0, 200);
//        Producto p2 = new Producto("002", "Polera", Categoria.HOMBRE, Talla.M, 5000.0, 200);
//        productos.put(p1.getCodigo(), p1);
//        productos.put(p2.getCodigo(), p2);
//        for(String keys: productos.keySet()) {
//        	System.out.println(keys + " " + productos.get(keys));
//        }
//        Util.save(productos, "productos.txt");
//        
//        Map<String, Cliente> clientes = new HashMap<>();
//        Cliente c1 = new Cliente("15335", "Juan", "Oh", "Meiggs 123", "123456", "jioh@mail.com");
//        Cliente c2 = new Cliente("17852", "Marcelo", "Toro", "Vitacura 321", "987654", "marcelo@mail.com");
//        clientes.put(c1.getId(), c1);
//        clientes.put(c2.getId(), c2);
//        Util.save(clientes, "clientes.txt");
//        
//        Map<String, Venta> ventas = new HashMap<>();
//        Map<Producto, Integer> compras1 = new HashMap<>();
//        compras1.put(p1, 10);
//        compras1.put(p2, 5);
//        Map<Producto, Integer> compras2 = new HashMap<>();
//        compras2.put(p1, 1);
//        compras2.put(p2, 50);
//        Venta v1 = new Venta("001", LocalDate.now(), c1, compras1, 0.1);
//        Venta v2 = new Venta("002", LocalDate.now(), c2, compras2, 0.15);
//        ventas.put(v1.getId(), v1);
//        ventas.put(v2.getId(), v2);
//        Util.save(ventas, "ventas.txt");
//        for(String keys: ventas.keySet()) {
//        	System.out.println(keys + " " + ventas.get(keys));
//        }
        
        
        
    }
}
