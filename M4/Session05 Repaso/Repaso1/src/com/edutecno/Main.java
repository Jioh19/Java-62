package com.edutecno;

public class Main {

	public static void main(String[] args) {
		Auto tesla = new Auto(5000, "Tesla");
		Auto toyota = new Auto(6500, "Toyota");
		Auto kia = new Auto(4500, "Kia");
		Auto ford = new Auto(4000, "Ford");
		
		Auto[] autos = {tesla, toyota, kia, ford};
		
		for(Auto marca: autos) {
			System.out.println(marca);
			//vamos a cargar el vehiculo
			marca.cargar(180);
			System.out.println(marca);
			marca.avanzar(40);
			System.out.println(marca);
			double distancia = marca.maxDist();
			System.out.println("Con la bateria que queda, el auto puede avanzar: " +distancia);
			marca.avanzar(100);
			System.out.println(marca);
		}
		
		
		
	}

}
