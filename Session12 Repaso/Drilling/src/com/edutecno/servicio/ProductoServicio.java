package com.edutecno.servicio;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.edutecno.model.Producto;

public class ProductoServicio {
	// ArrayList, aun no lo vemos, lo veremos en profundidad la proxima clase.
	private List<Producto> productos;

	public ProductoServicio() {
		super();
		productos = new ArrayList<>();
	}

	public void getProductos() {
		String archivo = "productos.xlsx";
		// Este es el try clasico. Despues de usarlo hay que cerrar los recursos
//		try {
//			FileInputStream file = new FileInputStream(new File(archivo));
//			file.close();
//		} catch(Exception e) {
//			System.out.println("Error al abrir el archivo " + e);
//		} 

		// Try with resources. Este try cierra automaticamente los recursos.
		try (FileInputStream file = new FileInputStream(new File(archivo))) {
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			String cellValue = null;

			// Empecemos a usar un arraylist
			ArrayList<String> datos;

			for (Row row : sheet) {
				datos = new ArrayList<>();
				Producto producto;
				for (Cell cell : row) {
					cellValue = dataFormatter.formatCellValue(cell);
					// System.out.println(cellValue);
					// A diferencia de los arreglos, para agregar info a una lista se usa el
					// metodo add(). El objeto se agrega al final.
					datos.add(cellValue);
				}
				// Para usar los objetos de una lista, se tiene que usar el metodo get()
				producto = new Producto(datos.get(0), datos.get(2), Integer.parseInt(datos.get(1)));
				// Agregar el producto dentro de nuestra lista de productos
				productos.add(producto);
			}
			// System.out.println(productos);
		} catch (Exception e) {
			System.out.println("Error al abrir el archivo " + e);
		}
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Producto> getTodo() {
		return productos;
	}

	// Método que nos retorna el producto según el código ingresado
	public Producto getProducto(String codigo) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				return producto;
			}
		}
		return null;
	}

	public int total(List<Producto> carrito) {
		int total = 0;
		for (Producto producto : carrito) {
			total += producto.getPrecio();
		}
		return total;
	}

	public void boleta(List<Producto> carrito) {
		try (FileWriter archivo = new FileWriter("boleta.txt"); PrintWriter pw = new PrintWriter(archivo)) {
			pw.println("Total cancelado: " + total(carrito));
			pw.println("El detalle es: ");
			for (Producto producto : carrito) {
				pw.println(producto.getNombre() + " $" + producto.getPrecio());
			}
			pw.println("Gracias por preferirnos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void csv(List<Producto> carrito) {
		try (FileWriter archivo = new FileWriter("boleta.csv"); PrintWriter pw = new PrintWriter(archivo)) {
			for (Producto producto : carrito) {
				pw.println(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCodigo());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
