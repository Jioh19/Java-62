package com.edutecno;

public class CiclosAnidados {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
//				if (j > 5) {
//					break; // switch
//				}
				if ( j % 2 == 0) {
					continue;
				}
				System.out.println(i + " " + j);
			}
		}

	}

}
