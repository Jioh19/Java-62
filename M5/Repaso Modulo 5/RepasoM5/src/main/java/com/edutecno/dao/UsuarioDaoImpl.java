package com.edutecno.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.edutecno.model.Usuario;

public class UsuarioDaoImpl implements Dao<Usuario>{
	static private List<Usuario> usuarios;
	private static final String[] HEADERS = {"nombre", "apellido", "username", "password"};
	private String path = "/home/jioh/Projects/Edutecno/Java-62/Clases/M5/Repaso Modulo 5/RepasoM5/";
	private String file = "usuarios.xlsx";
	
	public UsuarioDaoImpl() {
		super();
		usuarios = new ArrayList<>();
	}

	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}

	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getByUsername(String username) {
		for(Usuario usuario: usuarios) {
			if(usuario.getUsername().equals(username)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public void save(Usuario t) {
		usuarios.add(t);
		saveToFile();
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void loadFromFiles() {
		try(FileInputStream fis = new FileInputStream(path+file);
				XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheetAt(0);
			usuarios.clear();
			
			for(int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row row = sheet.getRow(rowNum);
				Usuario usuario = new Usuario();
				usuario.setNombre(row.getCell(0).getStringCellValue());
				usuario.setApellido(row.getCell(1).getStringCellValue());
				usuario.setUsername(row.getCell(2).getStringCellValue());
				usuario.setPassword(row.getCell(3).getStringCellValue());
				
				usuarios.add(usuario);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void saveToFile() {
		try(XSSFWorkbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Usuarios");
			
			Row headerRow = sheet.createRow(0);
			for(int i = 0; i < HEADERS.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}
			
			for(int i = 0; i < usuarios.size(); i++) {
				Usuario usuario = usuarios.get(i);
				Row row = sheet.createRow(i+1);
				
				row.createCell(0).setCellValue(usuario.getNombre());
				row.createCell(1).setCellValue(usuario.getApellido());
				row.createCell(2).setCellValue(usuario.getUsername());
				row.createCell(3).setCellValue(usuario.getPassword());
			}
			
			try(FileOutputStream fileOut = new FileOutputStream(path + file)) {
				workbook.write(fileOut);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
