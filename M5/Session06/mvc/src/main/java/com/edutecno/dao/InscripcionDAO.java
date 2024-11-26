package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.entities.FormaPagoDTO;
import com.edutecno.entities.InscripcionDTO;
import com.edutecno.util.ConexionBD;

public class InscripcionDAO {
	public int insertarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		int max = 0;
		// Query para obtener una secuencia y asignar un id. La funcion MAX soloobtiene
		// el valor de id_inscripcion
		// y le suma 1, con eso hacemos el incremento
		String consultaProximoId = " SELECT MAX(id_inscripcion)+1 FROM inscripcion";
		// Query que insertara el valor
		String insertarInscripcion = " INSERT INTO inscripcion VALUES (?,?,?,?,?) ";
		// conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = ConexionBD.getConexion();
		try (PreparedStatement stmt1 = conexion.prepareStatement(consultaProximoId);
				PreparedStatement stmt2 = conexion.prepareStatement(insertarInscripcion);) {
			ResultSet resultado = stmt1.executeQuery();
			if (resultado.next()) {
				max = resultado.getInt(1);
				stmt2.setInt(1, max);
				stmt2.setString(2, dto.getNombre());
				stmt2.setString(3, dto.getTelefono());
				stmt2.setInt(4, dto.getIdCurso());
				stmt2.setInt(5, dto.getIdFormaPago());
				if (stmt2.executeUpdate() != 1) {
					throw new RuntimeException("A ocurrido un error inesperado");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("A ocurrido un error inesperado" + ex);
		}
		return max;
	}

	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
		// creamos la lista de objetos que devolveran los resultados
		List<InscripcionDTO> inscripciones = new ArrayList<InscripcionDTO>();
		// creamos la consulta a la base de datos
		String consultaSql = " SELECT * " + " FROM inscripcion ";
		// conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = ConexionBD.getConexion();
		try (PreparedStatement stmt = conexion.prepareStatement(consultaSql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				InscripcionDTO inscripcion = new InscripcionDTO();
				inscripcion.setIdInscripcion(resultado.getInt("id_inscripcion"));
				inscripcion.setNombre(resultado.getString("nombre"));
				inscripcion.setTelefono(resultado.getString("telefono"));
				inscripcion.setIdCurso(resultado.getInt("id_curso"));
				inscripcion.setIdFormaPago(resultado.getInt("id_forma_pago"));
				inscripciones.add(inscripcion);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return inscripciones;
	}
	
	public static void main(String[] args) {
		InscripcionDAO dao = new InscripcionDAO();
		InscripcionDTO dto = new InscripcionDTO();
		dto.setIdCurso(1);
		dto.setIdFormaPago(1);
		dto.setIdInscripcion(1);
		dto.setNombre("Inscripcion 1");
		dto.setTelefono("123456");

		try {
			dao.insertarInscripcion(dto);
			List<InscripcionDTO> cursos = dao.obtieneInscripciones();
			cursos.stream().forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
