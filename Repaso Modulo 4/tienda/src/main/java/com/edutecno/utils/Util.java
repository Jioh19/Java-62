package com.edutecno.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import com.edutecno.modelos.Categoria;
import com.edutecno.modelos.Cliente;
import com.edutecno.modelos.Producto;
import com.edutecno.modelos.Talla;

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
		try (FileReader fr = new FileReader(file); 
				BufferedReader br = new BufferedReader(fr)) {
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
		try (FileReader fr = new FileReader(file); 
				BufferedReader br = new BufferedReader(fr)) {
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

}
