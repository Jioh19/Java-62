package com.edutecno.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutecno.banco.model.Cliente;

@Repository
public class ClienteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * CRUD
	 */
	
	//Create 
	public void save(Cliente cliente) {
		String sql = "INSERT INTO CLIENTE (rut, nombre, apellido, username, password) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql,
				cliente.getRut(),
				cliente.getNombre(),
				cliente.getApellido(),
				cliente.getUsername(),
				cliente.getPassword()
				);
	}
	//Read
	public List<Cliente> findAll() {
		String sql = "SELECT * FROM CLIENTE";
		List<Cliente> misClientes = jdbcTemplate.query(sql, new ClienteMapper());
		return misClientes;
	}
	
	//findByRut
	public Cliente findByRut(String rut) {
		String sql = "SELECT * FROM CLIENTE WHERE rut = ?";
		return jdbcTemplate.queryForObject(sql, new ClienteMapper(), rut);
	}
	
	//Update
	public void update(Cliente cliente) {
		String sql = "UPDATE CLIENTE SET nombre=?, apellido=?, username=?, password=? WHERE rut=?";
		jdbcTemplate.update(sql,
				cliente.getNombre(),
				cliente.getApellido(),
				cliente.getUsername(),
				cliente.getPassword(),
				cliente.getRut()
				);
	}
	
	//Delete
	public void delete(String rut) {
		String sql = "DELETE FROM CLIENTE WHERE rut=?";
		jdbcTemplate.update(sql, rut);
	}
}
