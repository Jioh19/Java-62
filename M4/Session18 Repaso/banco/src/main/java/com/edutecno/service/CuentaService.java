package com.edutecno.service;

import java.util.List;

import com.edutecno.excepciones.CuentaException;
import com.edutecno.model.Cuenta;
import com.edutecno.model.TipoTransaccion;
import com.edutecno.model.Transaccion;

public class CuentaService {
	private List<Cuenta> cuentas;

	public CuentaService(List<Cuenta> cuentas) {
		super();
		this.cuentas = cuentas;
	}

	public void addCuenta(Cuenta cuenta) {
		cuentas.add(cuenta);
	}

	public void setCuenta(int index, Cuenta cuenta) {
		cuentas.set(index, cuenta);
	}

	public void removeCuenta(int index) {
		cuentas.remove(index);
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public boolean depositar(Cuenta cuenta, double deposito) throws CuentaException {
		if (cuenta.canDepositar(deposito)) {
			cuenta.depositar(deposito);
			Transaccion trans = new Transaccion(deposito, null, cuenta, TipoTransaccion.DEPOSITO);
			cuenta.getTransaccionService().addTransaccion(trans);
			return true;
		}
		return false;
	}

	public boolean retirar(Cuenta cuenta, double retiro) throws CuentaException {
		if (cuenta.canRetirar(retiro)) {
			cuenta.retirar(retiro);
			Transaccion trans = new Transaccion(retiro, cuenta, null, TipoTransaccion.RETIRO);
			cuenta.getTransaccionService().addTransaccion(trans);
			return true;
		}
		return false;
	}

	public boolean transferir(Cuenta origen, Cuenta destino, double monto) throws CuentaException {
		if (origen.canRetirar(monto) && destino.canDepositar(monto)) {
			origen.retirar(monto);
			destino.depositar(monto);
			Transaccion trans = new Transaccion(monto, origen, destino, TipoTransaccion.TRANSFERENCIA);
			origen.getTransaccionService().addTransaccion(trans);
			destino.getTransaccionService().addTransaccion(trans);
			return true;
		}
		return false;
	}

	public Cuenta getCuenta(int index) throws CuentaException {
		try {
			Cuenta cuenta = cuentas.get(index);
			return cuenta;
		} catch (Exception e) {
			throw new CuentaException("Error, cuenta no encontrada");
		}
	}
}
