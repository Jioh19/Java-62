package com.edutecno.model;

import java.time.LocalDateTime;

public class Transaccion {
	private double monto;
	private Cuenta origen;
	private Cuenta destino;
	private LocalDateTime fecha;
	private TipoTransaccion tipo;

	public Transaccion(double monto, Cuenta origen, Cuenta destino, TipoTransaccion tipo) {
		super();
		this.monto = monto;
		this.origen = origen;
		this.destino = destino;
		this.tipo = tipo;
		fecha = LocalDateTime.now();
	}

	public double getMonto() {
		return monto;
	}

	public Cuenta getOrigen() {
		return origen;
	}

	public Cuenta getDestino() {
		return destino;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public TipoTransaccion getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		if(tipo == TipoTransaccion.DEPOSITO || tipo == TipoTransaccion.RETIRO) {
			return String.format("\nTransaccion [monto=%s, fecha=%s, tipo=%s]", monto, fecha, tipo);	
		} else if (tipo == TipoTransaccion.TRANSFERENCIA) {
			return String.format(""
					+ "\nTransaccion [monto=%s, fecha=%s, tipo=%s, origen=%s, destino=%s]", 
					monto, fecha, tipo, origen.getNumero(), destino.getNumero());	
		}
		return "";
	}

}
