package principal;

import java.util.Scanner;

import modelos.Cocina;
import modelos.Producto;
import modelos.Refrigerador;

public class Main {

	public static void main(String[] args) {
		Producto cocina = new Cocina(80000, 10, 4);
		Producto refrigerador = new Refrigerador(150000, 15, 2, "A");
		
		Producto[] productos = {cocina, refrigerador};
		Scanner sc = new Scanner(System.in);
		String menu = """
Seleccione el producto a comprar
1- Cocina
2- Refrigerador""";
		System.out.println(menu);
		int eleccion = sc.nextInt();
		switch (eleccion) {
		case 1: {
			System.out.println(productos[eleccion-1]);
			System.out.println("Presion Y para continuar. N para cancelar");
			String comprar = sc.next();
			if(comprar.toLowerCase().equals("y")) {
				System.out.println("Felicidades has comprado tu cocina");
				System.out.println("Desea incluir un gas por 5000?");
				if(sc.next().toLowerCase().equals("y")) {
					System.out.println("Felicidades ha comprado su cocina incluyendo el gas");
				} else {
					System.out.println("Felicidades ha comprado su cocina sin gas");
				}
				((Cocina)cocina).cambiarStock(1);
				System.out.println("Nueva cantidad de articulos: " + cocina.getStock());
			}
			break;
		}
		case 2: {
			System.out.println(productos[eleccion-1]);
			System.out.println("Presion Y para continuar. N para cancelar");
			String comprar = sc.next();
			if(comprar.toLowerCase().equals("y")) {
				System.out.println("Felicidades has comprado tu refrigerador");
				((Refrigerador)refrigerador).cambiarStock(1);
				System.out.println("Nueva cantidad de articulos: " + refrigerador.getStock());
			}
			break;			
		}
		default:
			System.out.println("Producto no encontrado");
		}
		
	}
	
	

}
