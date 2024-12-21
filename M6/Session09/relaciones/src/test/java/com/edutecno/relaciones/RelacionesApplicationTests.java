package com.edutecno.relaciones;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edutecno.relaciones.model.Auto;
import com.edutecno.relaciones.model.Persona;
import com.edutecno.relaciones.repository.AutoRepository;
import com.edutecno.relaciones.repository.PersonaRepository;

@SpringBootTest
class RelacionesApplicationTests {

	@Autowired
	private AutoRepository autoRepository;
	@Autowired
	private PersonaRepository personaRepository;
	
	@Test
	void validaRepoCreandoAutoPersona() {
		
		Persona persona = new Persona(null, "Juan", "15335", null);
		Auto auto = new Auto(null, "Daewoo Nubira", "TYTY27", 2001, persona);
		
		List<Auto> autos = new ArrayList<>();
		autos.add(auto);
		persona.setAutos(autos);
		
		personaRepository.save(persona);
		autoRepository.save(auto);
		Auto recuperado = autoRepository.findById(1l).orElseThrow(()-> new RuntimeException("Auto no encontrado"));
		
		assertNotNull(recuperado);
	}
	
	@Test
	void validaDatos() {
		Persona persona = new Persona();
		persona.setNombre("Marcelo");
		persona.setRut("19553");
		Auto auto = new Auto();
		auto.setModelo("M3");
		auto.setPatente("TYTY34");
		auto.setAnio(2024);
		
		personaRepository.save(persona);
		auto.setPersona(persona);
		autoRepository.save(auto);
		
		List<Auto> autos = new ArrayList<>();
		persona.setAutos(autos);
		autos.add(auto);
		
		assertNotNull(personaRepository.findAll());
		assertNotNull(autoRepository.findAll());
	}

}
