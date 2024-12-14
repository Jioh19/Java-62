package com.edutecno.controlAgricola;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edutecno.controlAgricola.dao.ArbolRepository;
import com.edutecno.controlAgricola.model.Arbol;

@SpringBootApplication
public class ControlAgricolaApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(ControlAgricolaApplication.class, args);
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
		ArbolRepository arbolDao = acac.getBean(ArbolRepository.class);
		Arbol arbol = new Arbol();
		arbol.setLng(new BigDecimal(45.40));
		arbol.setLat(new BigDecimal(40.40));
		arbol.setAltura(new BigDecimal(36.5));
		arbol.setRadio(new BigDecimal(0.5));
		arbol.setTipoArbol("Alerce");
		arbol.setTratamiento("Regar tres veces por semana");
		//System.out.println(arbolDao.findById(21));
		var arboles = arbolDao.buscarPorTipoDeArbol("Alerce");
		arboles.forEach(System.out::println);
	}

}
