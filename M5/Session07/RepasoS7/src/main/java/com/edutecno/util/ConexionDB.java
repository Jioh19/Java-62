package com.edutecno.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionDB {

	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;

	// EJEMPLO DE CONEXION SIN SINGLETON
	protected Connection generaConexion() {
		String usr = "JIOH";
		String pwd = "1160";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, usr, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Se entrega nueva conexion");
		} else {
			System.out.println("Se entrega conexion existente");
		}
		return conn;
	}
}
