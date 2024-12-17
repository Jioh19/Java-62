package com.edutecno.banco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.edutecno.banco.model.Cuenta;

@Repository
public class CuentaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ClienteRepository clienteRepository;
	
	private final RowMapper<Cuenta> cuentaMapper = (rs, rowNum) -> {
		Cuenta cuenta = new Cuenta();
		cuenta.setId(rs.getInt("id"));
		cuenta.setSaldo(rs.getInt("saldo"));
		String rut = rs.getString("cliente_rut");
		cuenta.setCliente(clienteRepository.findByRut(rut));
		return cuenta;
	};
	
	/**
	 * CRUD
	 */
	
	//Create
	public void save(Cuenta cuenta) {
		String sql = "INSERT INTO cuenta (id, saldo, cliente_rut) VALUES(?,?,?)";
		jdbcTemplate.update(sql, cuenta.getId(), cuenta.getSaldo(), cuenta.getCliente().getRut());
	}
	
	//Read
	public List<Cuenta> getAll() {
		String sql = "SELECT * FROM CUENTA";
		return jdbcTemplate.query(sql, cuentaMapper);
	}
	
	public Cuenta getById(int id) {
		String sql = "SELECT * FROM CUENTA WHERE id=?";
		return jdbcTemplate.queryForObject(sql, cuentaMapper, id);
	}
	
	//Update
	public void update(Cuenta cuenta) {
		String sql = "UPDATE cuenta SET saldo=?, cliente_rut=? WHERE id=?";
		jdbcTemplate.update(sql, 
				cuenta.getSaldo(),
				cuenta.getCliente().getRut(),
				cuenta.getId()
				);
	}
	
	//Delete
	public void delete(int id) {
		String sql = "DELETE FROM cuenta WHERE id=?";
		jdbcTemplate.update(sql, id);
	}
}
