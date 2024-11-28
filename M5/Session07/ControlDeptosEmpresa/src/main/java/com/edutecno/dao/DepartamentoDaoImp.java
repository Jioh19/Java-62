package com.edutecno.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Departamento;
import com.edutecno.procesaConexion.AdministradorConexion;

public class DepartamentoDaoImp extends AdministradorConexion 
implements DepartamentoDao{

	
	public DepartamentoDaoImp() {
		conn = generaConexion();
	}

	@Override
	public List<Departamento> obtieneDepartamento() {
		List<Departamento> deptos = new ArrayList<>();
		String sql = "SELECT * FROM DEPARTAMENTO";
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Departamento depto = new Departamento(
						rs.getInt("NUMDEPTO"),rs.getString("NOMDEPTO"),
						rs.getString("UBICACIONDPTO"));
				deptos.add(depto);
				System.out.println(depto);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return deptos;
	}

}
