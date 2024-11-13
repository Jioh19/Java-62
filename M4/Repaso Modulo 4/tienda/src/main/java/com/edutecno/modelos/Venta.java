package com.edutecno.modelos;

import java.time.LocalDate;
import java.util.Map;

public class Venta {
	private String id;
	private LocalDate fecha;
	private Cliente cliente;
	private Map<Producto, Integer> ventas;
	private double descuento;
	
	public Venta(String id, LocalDate fecha, Cliente cliente, Map<Producto, Integer> ventas, double descuento) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.ventas = ventas;
		this.descuento = descuento;
	}
	public Venta() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Map<Producto, Integer> getVentas() {
		return ventas;
	}
	public void setVentas(Map<Producto, Integer> ventas) {
		this.ventas = ventas;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	@Override
	public String toString() {
		return "id=" + id + ", fecha=" + fecha + ", cliente=" + cliente.getId() + ", ventas=" + ventas + ", descuento="
				+ descuento;
	}
	
	
}
