package com.edutecno;

import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "input.txt";
		int total = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			for(String line; (line = br.readLine()) != null; ) {
				System.out.println(line);
				for(int i = 0; i < line.length(); i++) {
					if(line.charAt(i) <= '9' && line.charAt(i) >= '0') {
						total += Character.getNumericValue(line.charAt(i)) * 10;
						break;
					}
				}
				for(int i = line.length() -1; i >= 0; i--) {
					if(line.charAt(i) <= '9' && line.charAt(i) >= '0') {
						total += Character.getNumericValue(line.charAt(i));
						break;
					}
				}
			}
		}catch(Exception e) {
			System.out.println("No se encontro el archivo " + e);
		}
		
		System.out.println(total);
	}
}
