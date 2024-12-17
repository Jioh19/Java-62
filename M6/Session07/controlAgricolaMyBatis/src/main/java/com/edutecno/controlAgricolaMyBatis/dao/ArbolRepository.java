package com.edutecno.controlAgricolaMyBatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.edutecno.controlAgricolaMyBatis.model.Arbol;

@Mapper
public interface ArbolRepository {
	
	@Select("select * from arbol order by lng asc")
	List<Arbol> findAll();
	
	@Select("SELECT * FROM ARBOL WHERE ID = #{id}")
	Arbol findById(Arbol arbol);
	
	@Insert("INSERT INTO ARBOL (ID, LNG, LAT, ALTURA, RADIO, "
			+ "TIPO_ARBOL, TRATAMIENTO) VALUES(#{id}, #{lng},"
			+ "#{lat}, #{altura}, #{radio}, #{tipo_arbol},"
			+ "#{tratamiento})")
	void insert(Arbol arbol);
	
	@Delete("DELETE FROM ARBOL WHERE ID = #{id}")
	void delete(Integer id);
	
	@Update("UPDATE ARBOL SET LNG=#{lng}, LAT=#{lat}, ALTURA=#{altura},"
			+ "RADIO=#{radio}, TIPO_ARBOL=#{tipo_arbol},"
			+ "TRATAMIENTO=#{tratamiento} WHERE ID=#{id}")
	void update(Arbol arbol);
}
