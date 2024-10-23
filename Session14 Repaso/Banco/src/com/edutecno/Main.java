package com.edutecno;

import java.util.Random;

import com.edutecno.controller.Banco;
import com.edutecno.excepciones.CuentaException;
import com.edutecno.model.Cliente;
import com.edutecno.model.Cuenta;
import com.edutecno.model.CuentaCorriente;
import com.edutecno.repository.CuentaRepository;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco();
		Cliente juan = banco.registrarCliente("Juan", "Oh", "123456");
		Cliente marcelo = banco.registrarCliente("Marcelo", "Toro", "984654");
		Cuenta cuentaJuan = banco.crearCuenta(juan);
		Cuenta cuentaMarcelo = banco.crearCuenta(marcelo);
		
		try {
			Cuenta juancho = banco.getCuentaService().getCuenta(0);
			juancho.depositar(1000000);
			banco.getCuentaService().depositar(cuentaMarcelo, 2000000);
			banco.getCuentaService().retirar(cuentaJuan, 500000);
			banco.getCuentaService().transferir(cuentaJuan, cuentaMarcelo, 250000);			
		} catch(CuentaException e) {
			System.out.println("Operacion fallida " + e);
		} catch(Exception e) {
			System.out.println("Error " +e );
		}
		
		banco.getClienteService().getClientes().stream().filter(c -> c.getNombre().equals("Juan")).forEach(System.out::println);	
		System.out.println(banco);
		CuentaRepository.imprimir(cuentaJuan);
		//System.out.println(cuentaMarcelo);
	}

}
