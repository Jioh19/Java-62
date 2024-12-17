package com.edutecno.controlAgricolaMyBatis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edutecno.controlAgricolaMyBatis.config.AppConfig;
import com.edutecno.controlAgricolaMyBatis.dao.ArbolRepository;
import com.edutecno.controlAgricolaMyBatis.model.Arbol;

@SpringBootApplication
public class ControlAgricolaMyBatisApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(ControlAgricolaMyBatisApplication.class, args);
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
		ArbolRepository arbolDao = acac.getBean(ArbolRepository.class);
		List<Arbol> arboles = arbolDao.findAll();
		arboles.forEach(System.out::println);
		Arbol arbol = new Arbol();
		arbol.setId(21);
		arbol = arbolDao.findById(arbol);
		System.out.println(arbol);
		arbolDao.delete(1);
		arbol.setId(1);
		arbol.setLat(new BigDecimal(0.5));
		arbol.setLng(new BigDecimal(0.5));
		arbol.setAltura(new BigDecimal(10.5));
		arbol.setRadio(new BigDecimal(1.4));
		arbol.setTipo_arbol("prueba de insercion");
		arbol.setTratamiento("esto es una prueba de insercion");
		arbolDao.insert(arbol);
		//arbolDao.delete(24);
		arbol.setTipo_arbol("Nombre updateado");
		arbol.setTratamiento("Tratamiento updateado");
		arbolDao.update(arbol);
	}

}
