package com.edutecno.procesaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdministradorConexion {
	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;

	// EJEMPLO DE CONEXION SIN SINGLETON
	protected Connection generaConexion() {
		String usr = "JIOH";
		String pwd = "1160";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
		if(conn == null) {
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

	protected Connection generaPoolConexion() {
		Context initContext;
		if (conn == null) {
			try {
				initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionOracle");
				try {
					conn = ds.getConnection();
					System.out.println("CREACION DE CONEXION CON GetConnection");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
			return conn;
		} else {
			System.out.println("Ya hay una conexion");
			return conn;
		}
	}
}
