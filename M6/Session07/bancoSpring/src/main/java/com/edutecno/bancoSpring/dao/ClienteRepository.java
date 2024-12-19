package com.edutecno.bancoSpring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.edutecno.bancoSpring.model.Cliente;

@Mapper
public interface ClienteRepository{

	// Create
	@Insert("INSERT INTO CLIENTES ( rut, nombre, apellido, username, password) VALUES("
			+ " #{rut}, #{nombre}, #{apellido}, #{username}, #{password})")
	void save(Cliente cliente);
	
	// Read
	@Select("SELECT * FROM CLIENTES")
	List<Cliente> findAll();
	
	@Select("SELECT * FROM CLIENTES WHERE RUT = #{rut}")
	Cliente findByRut(String rut);
	
	@Select("SELECT * FROM CLIENTES WHERE ID = #{id}")
	Cliente findById(int id);
	
	
}
