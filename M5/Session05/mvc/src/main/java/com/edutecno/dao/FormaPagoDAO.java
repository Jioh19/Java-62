package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.entities.CursoDTO;
import com.edutecno.entities.FormaPagoDTO;
import com.edutecno.util.ConexionBD;

public class FormaPagoDAO {
	public List<FormaPagoDTO> obtieneFormasDePago() throws SQLException, ClassNotFoundException {
		// creamos la lista de objetos que devolveran los resultados
		List<FormaPagoDTO> formaDePago = new ArrayList<FormaPagoDTO>();
		// creamos la consulta a la base de datos
		String consultaSql = " SELECT id_forma_pago, descripcion, recarga" + " FROM forma_pago ";
		// conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = ConexionBD.getConexion();
		try (PreparedStatement stmt = conexion.prepareStatement(consultaSql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				FormaPagoDTO formaPago = new FormaPagoDTO();
				formaPago.setIdFormaPago(resultado.getInt("id_forma_pago"));
				formaPago.setDescripcion(resultado.getString("descripcion"));
				formaPago.setRecarga(resultado.getString("recarga"));
				formaDePago.add(formaPago);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return formaDePago;
	}
	
	public static void main(String[] args) {
		FormaPagoDAO dao = new FormaPagoDAO();
		try {
			List<FormaPagoDTO> cursos = dao.obtieneFormasDePago();
			cursos.stream().forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
