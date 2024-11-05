package com.edutecno.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.edutecno.model.Cuenta;
import com.edutecno.model.Transaccion;

public class CuentaRepository {
	static private String output = "./output/";

	public CuentaRepository() {
		super();
	}
	
	static public void imprimir(Cuenta cuenta) {
		output += cuenta.getNumero() + ".txt";
		File file = new File(output);
		try(FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw)) {
			for(Transaccion trans: cuenta.getTransaccionService().getTransacciones()) {
				pw.print(trans);
			}
		}catch(Exception e) {
			System.out.println("No se encontro el archivo" + e);
		}
	}
}
