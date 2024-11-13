package com.edutecno;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File("archivo.xlsx"));
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			String cellValue = null;
			// ArrayList<String> datos;
			ArrayList<ArrayList<String>> datos;
			datos = new ArrayList<>();
			for (Row row : sheet) {
				ArrayList<String> dato = new ArrayList<String>();
				for (Cell cell : row) {
					cellValue = dataFormatter.formatCellValue(cell);
					dato.add(cellValue);
				}
				datos.add(dato);
			}
			for (List<String> lista : datos) {
				System.out.println(lista);

			}

		} catch (Exception e) {
			System.out.println("No se pudo ingresar al fichero");
		}

		try {
			String ruta = "archivo.xlsx";
			FileInputStream file = new FileInputStream(new File(ruta));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet hoja = wb.getSheetAt(0);
			XSSFRow fila = hoja.createRow(0);
			XSSFCell celda = fila.createCell(1);
			celda.setCellType(CellType.STRING);
			
			ArrayList<String> colores = new ArrayList<>();
			colores.add("rojo");
			colores.add("verde");
			colores.add("amarillo");
			
			
			String misColores = String.join(",", colores);
			fila = hoja.createRow(0);
			for (int i = 0; i < colores.size(); i++) {
				fila.createCell(i).setCellValue(colores.get(i));
			}
			FileOutputStream cierre = new FileOutputStream(new File(ruta));
			wb.write(cierre);
			cierre.flush();
			cierre.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

}
