package com.edutecno;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> numeros = new HashMap<>();
		numeros.put("zero", 0);
		numeros.put("one", 1);
		numeros.put("two", 2);
		numeros.put("three", 3);
		numeros.put("four", 4);
		numeros.put("five", 5);
		numeros.put("six", 6);
		numeros.put("seven", 7);
		numeros.put("eight", 8);
		numeros.put("nine", 9);
		
		String file = "input.txt";
		int total = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			for(String line; (line = br.readLine()) != null; ) {
				//System.out.println(line);
				for(int i = 0; i < line.length(); i++) {
					var start = numString(line.substring(i), numeros);
					if(start != -1) {
						total += start*10;
						break;
					}
					if(line.charAt(i) <= '9' && line.charAt(i) >= '0') {
						total += Character.getNumericValue(line.charAt(i)) * 10;
						break;
					}
				}
				for(int i = line.length() -1; i >= 0; i--) {
					var end = numString(line.substring(i), numeros);
					if(end != -1) {
						total += end;
						break;
					}
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
	
	public static int numString(String line, Map<String, Integer> numeros) {
		for(var numero: numeros.entrySet()) {
			if(line.length() >= numero.getKey().length()) {
				String aux = line.substring(0, numero.getKey().length());
				if(aux.contains(numero.getKey())) {
					return numero.getValue();
				}
			}
		}
		return -1;
	}
}
