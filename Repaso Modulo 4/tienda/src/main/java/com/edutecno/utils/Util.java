package com.edutecno.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Util {
	
	public static <K, V> void save(Map<K, V> itemes, String archivo) {
		File file = new File(archivo);
		try(FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw)) {
		
			for(K keys: itemes.keySet()) {
				pw.println(itemes.get(keys));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
