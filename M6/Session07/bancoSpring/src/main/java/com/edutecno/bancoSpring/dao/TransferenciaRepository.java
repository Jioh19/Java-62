package com.edutecno.bancoSpring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.edutecno.bancoSpring.model.Transferencia;

@Mapper
public interface TransferenciaRepository{

	@Select("SELECT * FROM TRANSFERENCIA")
	@Results({
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "monto", column = "monto"),
        @Result(property = "origen", column = "CUENTA_ORIGEN_ID",
            one = @One(select = "com.edutecno.bancoSpring.dao.CuentaRepository.findById")),
        @Result(property = "destino", column = "CUENTA_DESTINO_ID",
        	one = @One(select = "com.edutecno.bancoSpring.dao.CuentaRepository.findById"))
    })
	List<Transferencia> findAll();
	
	@Insert("INSERT INTO TRANSFERENCIA (MONTO, CUENTA_ORIGEN_ID, CUENTA_DESTINO_ID) VALUES(#{monto}, "
			+ "#{origen.id}, #{destino.id})")
	void save(Transferencia transferencia);
}
