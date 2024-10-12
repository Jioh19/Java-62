package com.edutecno;

import java.util.Arrays;

public class CarritoCompras {
	private EstadoCarrito estadoActual;
	private String[] productos;

	public CarritoCompras(EstadoCarrito estadoActual) {
		super();
		this.estadoActual = estadoActual;
		productos = new String[10];
	}

	private void addProducto(String producto) {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] == null) {
				productos[i] = producto;
				break;
			}
		}
	}

	private void clear() {
		for (int i = 0; i < productos.length; i++) {
			productos[i] = null;
		}
	}

	private void setEstado(EstadoCarrito estado) {
		estadoActual = estado;
	}

	public void agregar(String producto) {
		estadoActual.agregar();
		if (estadoActual instanceof EstadoVacio) {
			addProducto(producto);
			estadoActual = new EstadoCargando();
		} else if (estadoActual instanceof EstadoCargando) {
			addProducto(producto);
		}
	}

	public void cancelar() {
		estadoActual.cancelar();
		if (estadoActual instanceof EstadoCargando) {
			clear();
			estadoActual = new EstadoVacio();
		} else if (estadoActual instanceof EstadoPagando) {
			clear();
			estadoActual = new EstadoVacio();
		}
	}

	public void volver() {
		estadoActual.volver();
		if(estadoActual instanceof EstadoCargando) {
			clear();
			estadoActual = new EstadoVacio();
		} else if(estadoActual instanceof EstadoPagando) {
			estadoActual = new EstadoCargando();
		}
	}

	public void siguiente() {
		estadoActual.siguiente();
		if(estadoActual instanceof EstadoCargando) {
			estadoActual = new EstadoPagando();
		} else if(estadoActual instanceof EstadoPagando) {
			estadoActual = new EstadoCerrado();
		} else if(estadoActual instanceof EstadoCerrado) {
			clear();
			estadoActual = new EstadoVacio();
		}
	}

	@Override
	public String toString() {
		return "CarritoCompras [estadoActual=" + estadoActual + "\nproductos=" + Arrays.toString(productos) + "]";
	}
	
	

}
