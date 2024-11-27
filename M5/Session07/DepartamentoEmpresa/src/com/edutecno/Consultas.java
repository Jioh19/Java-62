package com.edutecno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usr = "JIOH";
		String pwd = "1160";
		String driver = ("oracle.jdbc.driver.OracleDriver");
		String url = ("jdbc:oracle:thin:@localhost:1521/FREEPDB1");
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			// 1 PARTE LEVANTAR EL DRIVER
			// se levanta el driver
			Class.forName(driver);// se estable la conexion
			conn = DriverManager.getConnection(url, usr, pwd);
			// 2 PARTE GENERACION DE QUERY
			// se define la query
			String sql = "SELECT * FROM departamento, empleado";
			// sql = "insert into departamento values " + nombre + apellido;
			
			// se preparan las sentencias que se ejecutaran
			pstm = conn.prepareStatement(sql);
			// se ejecutan sentencia y obtienen los resultados
			rs = pstm.executeQuery();
			// se recorren los resultados
			while (rs.next()) {
				System.out.println("DEPARTAMENTOS:::");
				System.out.println(rs.getInt("NUMDEPTO"));
				System.out.println(rs.getString("NOMDEPTO"));
				System.out.println(rs.getString("UBICACIONDPTO"));
				System.out.println("EMPLEADOS:::");
				System.out.println(rs.getInt("NUMEMPLEADO"));
				System.out.println(rs.getString("NOMBRE"));
				System.out.println(rs.getInt("NUMDEPTO"));
			}
			
//			sql = "";
//			sql+="INSERT INTO DEPARTAMENTO (NUMDEPTO,NOMDEPTO,UBICACIONDPTO)";
//			sql+="VALUES(?,?,?)";
//			pstm = conn.prepareStatement(sql);
//			pstm.setInt(1, 6);
//			pstm.setString(2, "BIENESTAR");
//			pstm.setString(3, "CHILE");
//			int resultado = pstm.executeUpdate();
//			if(resultado == 1) {
//				System.out.println("Fila correctamente insertada");
//			} else {
//				System.out.println("Ocurrio un error insertando el departamento");
//			}
//			sql = "";
//			sql += "DELETE FROM DEPARTAMENTO WHERE NOMDEPTO = ?";
//			//preparamos sentencias que ejecutaremos
//			pstm = conn.prepareStatement(sql);
//			//adjuntamos los valores a los parametros
//			pstm.setString(1,"BIENESTAR");
//			int resultado = pstm.executeUpdate();
//			//si la variable resultado es mayor a 0 el insert fue correcto
//			if (resultado >= 1) {
//			System.out.println("Fila correctamente eliminada! " + resultado );
//			}else {
//			System.out.println("Ocurrio un error eliminando el departamento");
//			}
			
			sql = "UPDATE DEPARTAMENTO SET UBICACIONDPTO = ?";
			//preparamos sentencias que ejecutaremos
			pstm = conn.prepareStatement(sql);
			//adjuntamos los valores a los parametros
			pstm.setString(1,"JAPON");
			int resultado = pstm.executeUpdate();
			System.out.println(resultado + " filas actualizadas");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
