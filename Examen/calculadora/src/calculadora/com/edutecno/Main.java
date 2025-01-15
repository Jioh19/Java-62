package calculadora.com.edutecno;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola mundo");
		List<Integer> ingreso = new ArrayList<>();
		ingreso.add(7);
		ingreso.add(26);
		ingreso.add(39);
		ingreso.add(12);
		ingreso.add(44);
		
		CalculadoraStockSeguridad calcu = new CalculadoraSimple();
		List<Integer> resultado = calcu.calcula(ingreso);
		
		System.out.print("Stocks de Seguridad con Algoritmo Simple: ");
		for(Integer num: resultado) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		calcu = new CalculadoraCompleja();
		
		resultado = calcu.calcula(ingreso);
		
		System.out.print("Stocks de Seguridad con Algoritmo Complejo: ");
		for(Integer num: resultado) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
