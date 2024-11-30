package com.edutecno.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Empleado;
import com.edutecno.procesaConexion.AdministradorConexion;

public class EmpleadoDaoImp extends AdministradorConexion implements EmpleadoDao {

	public EmpleadoDaoImp() {
		super();
		conn = generaPoolConexion();
	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado> empleados = new ArrayList<>();
		String sql = "SELECT * FROM EMPLEADO";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Empleado empleado = new Empleado();
				empleado.setNumEmpleado(rs.getInt("numempleado"));
				empleado.setNombreEmpleado(rs.getString("nombre"));
				empleado.setNumDepto(rs.getInt("numdepto"));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public List<Empleado> busquedaEmpleado(String nombre, int numEmpleado, int numDepartamento) {
		String query = "SELECT * FROM EMPLEADO WHERE ";
		List<Empleado> empleados = new ArrayList<Empleado>();
		if ((nombre.isEmpty()) && (numEmpleado == 0 && numDepartamento == 0)) {
			query = "SELECT * FROM EMPLEADO ";
		} else {
			if ((!nombre.isEmpty() && (numEmpleado > 0) && (numDepartamento > 0))) {
				query.concat("NOMBRE = '" + nombre + "'" + "AND" + "NUMEMPLEADO = numEmpleado " + "AND "
						+ " NUMDEPTO = " + numDepartamento);
				query += "NOMBRE = '" + nombre + "'";
				query += " AND ";
				query += "NUMEMPLEADO = " + numEmpleado;
				query += " AND ";
				query += "NUMDEPTO = " + numDepartamento;
			} else if (!nombre.isEmpty()) {
				// query += "NOMBRE = '"+nombre+"'";
				query += "UPPER (NOMBRE) LIKE UPPER('%" + nombre + "%')";
				// SELECT * FROM EMPLEADO WHERE UPPER(NOMBRE) LIKE UPPER ('%bob%');
			} else if (numEmpleado > 0) {
				query += "NUMEMPLEADO = " + numEmpleado;
			} else if (numDepartamento > 0) {
				query += "NUMDEPTO = " + numDepartamento;
			}
		}
		System.out.println(query);
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Empleado empleado = new Empleado(rs.getInt("NUMEMPLEADO"), rs.getString("NOMBRE"),
						rs.getInt("NUMDEPTO"));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public void save(Empleado empleado) {
		String sql = "INSERT INTO EMPLEADO (NOMBRE, NUMDEPTO) VALUES(?, ?)";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, empleado.getNombreEmpleado());
			stmt.setInt(2, empleado.getNumDepto());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM EMPLEADO WHERE NUMEMPLEADO = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
