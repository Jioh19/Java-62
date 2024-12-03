package com.edutecno;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.edutecno.dao.UsuarioDaoImpl;
import com.edutecno.model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/home/jioh/Projects/Edutecno/Java-62/Clases/M5/Repaso Modulo 5/RepasoM5/";
		String file = "usuarios.xlsx";
		
//		try(FileInputStream fis = new FileInputStream(path+file);
//				XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//			Sheet sheet = workbook.getSheetAt(0);
//			
//			for(Row row : sheet) {
//				for(Cell cell: row) {
//					switch(cell.getCellType()) {
//					case STRING:
//						System.out.println(cell.getStringCellValue() + "\t");
//						break;
//					case NUMERIC: 
//						System.out.println(cell.getNumericCellValue() + "\t");
//						break;
//					default:
//						System.out.println("\t");
//					}
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
//		UsuarioDaoImpl dao = new UsuarioDaoImpl();
//		dao.loadFromFiles();
//		List<Usuario> usuarios = dao.getAll();
//		Usuario usuario = new Usuario("Sebastian", "Guzman", "sguz", "456f");
//		dao.save(usuario);
//		usuarios.forEach(System.out::println);
	}

}
