package com.edutecno.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Departamento;
import com.edutecno.modelo.DepartamentoEmpleado;
import com.edutecno.modelo.Empleado;
import com.edutecno.procesaConexion.AdministradorConexion;

public class DepartamentoEmpleadoDaoImp extends AdministradorConexion implements DepartamentoEmpleadoDao {

	public DepartamentoEmpleadoDaoImp() {
		Connection conn = generaPoolConexion();
	}

	@Override
	public List<DepartamentoEmpleado> obtieneDepartamento(String nomDepto) {
		List<DepartamentoEmpleado> deptosEmpleados = new ArrayList<DepartamentoEmpleado>();
		String query = "SELECT * FROM EMPLEADO EMP "
				+ "INNER JOIN DEPARTAMENTO DEP " + 
				"ON DEP.NUMDEPTO = EMP.NUMDEPTO "
				+ "WHERE ";
		if (nomDepto.isEmpty() && nomDepto.isEmpty()) {
			query = "SELECT * FROM EMPLEADO EMP INNER JOIN DEPARTAMENTO DEP "
					+ "ON DEP.NUMDEPTO = EMP.NUMDEPTO";
		} else {
			query += "DEP.NOMDEPTO LIKE UPPER('%" + nomDepto + "%')";
		}
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Departamento depto = new Departamento(rs.getInt("NUMDEPTO"), rs.getString("NOMDEPTO"),
						rs.getString("UBICACIONDPTO"));
				Empleado empleado = new Empleado(rs.getInt("NUMEMPLEADO"), rs.getString("NOMBRE"),
						rs.getInt("NUMDEPTO"));
				DepartamentoEmpleado deptoEmpl = new DepartamentoEmpleado(depto, empleado);
				deptosEmpleados.add(deptoEmpl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptosEmpleados;
	}


}
