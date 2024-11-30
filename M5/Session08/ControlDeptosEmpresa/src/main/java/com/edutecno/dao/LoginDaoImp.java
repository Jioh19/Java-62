package com.edutecno.dao;

import java.sql.SQLException;

import com.edutecno.procesaConexion.AdministradorConexion;

public class LoginDaoImp extends AdministradorConexion implements LoginDao {

	public LoginDaoImp() {
		super();
		conn = generaPoolConexion();
	}

	@Override
	public boolean usuarioRegistrado(int id, String nombre, int depto) {
		boolean usuarioExiste = false;
		String sql = "SELECT * FROM EMPLEADO WHERE NUMEMPLEADO = ? AND NOMBRE = ? and NUMDEPTO = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, nombre);
			pstm.setInt(3, depto);
			rs = pstm.executeQuery();
			if (rs.next()) {
				usuarioExiste = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioExiste;
	}

}
