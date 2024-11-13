package com.edutecno.factory;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		System.out.println("Ingrese la cantidad de lados");
		Scanner sc = new Scanner(System.in);
		int lados = sc.nextInt();
		Figura figura = FabricaFiguras.crearFigura(lados);
		//Es necesario verificar si es nulo, ya que por definición va a entregar nulo si no
		//existe la figura con los lados pedidos
		if(figura == null) {
			return;
		}
		figura.dibujar();
	}
}
