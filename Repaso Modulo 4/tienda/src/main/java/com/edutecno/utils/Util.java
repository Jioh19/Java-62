package com.edutecno.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.edutecno.modelos.Categoria;
import com.edutecno.modelos.Cliente;
import com.edutecno.modelos.Producto;
import com.edutecno.modelos.Talla;
import com.edutecno.modelos.Venta;
import com.edutecno.servicios.ClienteService;
import com.edutecno.servicios.ProductoService;

public class Util {

	public static <K, V> void save(Map<K, V> itemes, String archivo) {
		File file = new File(archivo);
		try (FileWriter fw = new FileWriter(file); PrintWriter pw = new PrintWriter(fw)) {

			for (K keys : itemes.keySet()) {
				pw.println(itemes.get(keys));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadProducto(Map<String, Producto> itemes, String archivo) {
		File file = new File(archivo);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String[] datos = {};
			for (String line; (line = br.readLine()) != null;) {
				Producto producto = new Producto();
				datos = line.split(", ");
				producto.setCodigo(datos[0].split("=")[1]);
				producto.setNombre(datos[1].split("=")[1]);
				producto.setCategoria(Categoria.valueOf(datos[2].split("=")[1]));
				producto.setTalla(Talla.valueOf(datos[3].split("=")[1]));
				producto.setPrecio(Double.valueOf(datos[4].split("=")[1]));
				producto.setStock(Integer.valueOf(datos[5].split("=")[1]));
				itemes.put(producto.getCodigo(), producto);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadCliente(Map<String, Cliente> clientes, String archivo) {
		File file = new File(archivo);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String[] datos = {};
			for (String line; (line = br.readLine()) != null;) {
				Cliente cliente = new Cliente();
				datos = line.split(", ");
				cliente.setId(datos[0].split("=")[1]);
				cliente.setNombre(datos[1].split("=")[1]);
				cliente.setApellido(datos[2].split("=")[1]);
				cliente.setDireccion(datos[3].split("=")[1]);
				cliente.setTelefono(datos[4].split("=")[1]);
				cliente.setEmail(datos[5].split("=")[1]);
				clientes.put(cliente.getId(), cliente);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void loadVentas(Map<String, Venta> ventas, String archivo, ClienteService clienteService,
			ProductoService productoService) {
		File file = new File(archivo);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String[] datos = {};
			for (String line; (line = br.readLine()) != null;) {
				System.out.println(line);
				Venta venta = new Venta();
				datos = line.split(", ");
				for (String dato : datos) {
					System.out.println(dato.split("=")[1]);
				}
				venta.setId(datos[0].split("=")[1]);
				venta.setFecha(LocalDate.parse(datos[1].split("=")[1]));
				String codigoCliente = datos[2].split("=")[1];
				Cliente cliente = clienteService.obtenerCliente(codigoCliente);
				System.out.println("El cliente es: " + cliente);
				venta.setCliente(cliente);
				String lineProducts = line.split("\\{")[1];
				lineProducts = lineProducts.split("\\}")[0];
				System.out.println("La linea producto es: " + lineProducts);
				String[] lineProduct = lineProducts.split("codigo=");
				Map<Producto, Integer> ventasLinea = new HashMap<>();
				for(int i = 1; i < lineProduct.length; i++) {
					String[] producto = lineProduct[i].split("," );
					
					System.out.println(productoService.obtenerProducto(producto[0]));
					String stock = lineProduct[i].split("=")[6];
					stock = stock.split(",")[0];
					System.out.println("El compra es de: " + stock) ;
					ventasLinea.put(productoService.obtenerProducto(producto[0]), Integer.parseInt(stock));
				} 
				venta.setVentas(ventasLinea);
				ventas.put(venta.getId(), venta);
 				// System.out.println("La venta es: " + venta);
//				Cliente cliente = new Cliente();
//				datos = line.split(", ");
//				cliente.setId(datos[0].split("=")[1]);
//				cliente.setNombre(datos[1].split("=")[1]);
//				cliente.setApellido(datos[2].split("=")[1]);
//				cliente.setDireccion(datos[3].split("=")[1]);
//				cliente.setTelefono(datos[4].split("=")[1]);
//				cliente.setEmail(datos[5].split("=")[1]);
//				clientes.put(cliente.getId(), cliente);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
