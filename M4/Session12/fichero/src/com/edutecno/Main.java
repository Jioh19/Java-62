package com.edutecno;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "input.txt";
		String output = "./output/output.txt";
		long start = System.nanoTime();
		// Este es el método clásico para leer un archivo mediante el File Reader
		try {
			FileReader fr = new FileReader(file);
			int data = fr.read();
			// Tambien se puede leer el fr mediante un Scanner
			//Scanner sc = new Scanner(fr);
			String lectura = "";
			//Ciclo principal para copiar cada letra al string lectura.
			while(data != -1) {
				lectura += (char)data;			
				data = fr.read();
				}
			fr.close();
			System.out.println(lectura);
			long end = System.nanoTime();
			System.out.println("Se demoró " + (end-start));
			
		} catch (Exception e) {
			System.out.println("Archivo no encontrado\n" + e);
		}
		//Este es el método mucho más eficiente de leer un archivo mediante el Buffered Reader
		start = System.nanoTime();
		List<String> lineas = new ArrayList<>();
		try {
			FileReader fr = new FileReader(file);
			FileWriter fw = new FileWriter(output);
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(fw);
			for(String line; (line = br.readLine()) != null;) {
				System.out.println(line);
				lineas.add(line);
				String[] palabras = line.split(" ");
				pw.printf("%s %s %s %s\n", palabras[0], palabras[2], palabras[3], palabras[10].replace(".", ""));
			}
			br.close();
			fw.close();
			long end = System.nanoTime();
			System.out.println("Se demoró " + (end-start));
			System.out.println(lineas);
		} catch(Exception e) {
			System.out.println("Archivo no encontrado " + e); 
		} 
	}

}
