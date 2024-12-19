package com.edutecno.bancoSpring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.One;

import com.edutecno.bancoSpring.model.Cuenta;

@Mapper
public interface CuentaRepository{
	
	@Results(id="cuentaResultMap", value = {
			@Result(property = "id", column = "ID", id=true),
			@Result(property = "saldo", column ="SALDO"),
			@Result(property = "cliente", column ="CLIENTE_ID",
				one = @One(select = "com.edutecno.bancoSpring.dao.ClienteRepository.findById"))			
	})
	//Create
	@Insert("INSERT INTO CUENTAS (SALDO, CLIENTE_ID) VALUES(#{saldo}, #{cliente.id})")
	void save(Cuenta cuenta);
	
	// Read
	@Select("SELECT * FROM CUENTAS")
	@Results({
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "saldo", column = "SALDO"),
        @Result(property = "cliente", column = "CLIENTE_ID",
            one = @One(select = "com.edutecno.bancoSpring.dao.ClienteRepository.findById"))
    })
//	@ResultMap("cuentaResultMap")
	List<Cuenta> findAll();
	
	@Select("SELECT * FROM CUENTAS WHERE ID = ${id}")
	@Results({
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "saldo", column = "SALDO"),
        @Result(property = "cliente", column = "CLIENTE_ID",
            one = @One(select = "com.edutecno.bancoSpring.dao.ClienteRepository.findById"))
    })
	Cuenta findById(Integer id);
	
	@Update("UPDATE CUENTAS SET SALDO = #{saldo} WHERE ID = #{id}")
	void updateSaldo(Cuenta cuenta);
}
