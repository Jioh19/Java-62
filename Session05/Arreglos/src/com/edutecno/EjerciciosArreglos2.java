package com.edutecno;

import java.util.Arrays;

public class EjerciciosArreglos2 {
	public static void main(String[] args) {
		int[] arreglo = { 1, 5, 78, 3, 45, 41 };
//		
//		for(int i = 0; i < arreglo.length; i++) {
//			//arreglo[i] = arreglo[i] *2; //arreglo[i] *= 2;
//			System.out.println(arreglo[i]*2);
//		}
//		
//		for(int num: arreglo) {
//			System.out.println(num);
//		}

		// Imprimir el arreglo invertido
		for (int i = arreglo.length - 1; i >= 0; i--) {
			System.out.println(arreglo[i]);
		}

		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		int[][] matriz2 = new int[3][3];
		matriz2[0][0] = 0;
		
		
		System.out.println(matriz);
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(matriz);
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[j][matriz.length - i - 1] + " ");
			}
			System.out.println();
		}
	}
}
