package com.edutecno.principal;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.principal.model.Pelicula;
import com.edutecno.principal.repository.PeliculaRepositorio;

@SpringBootApplication
public class PrincipalApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PrincipalApplication.class, args);
	}

	@Autowired
	DataSource dataSource;
	@Autowired
	PeliculaRepositorio repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		List<Pelicula> peliculas = new ArrayList<>();
//		peliculas.add(new Pelicula(1, "Titanic", "Director1", 1996, 200));
//		peliculas.add(new Pelicula(2, "Titanic2", "Director2", 1997, 201));
//		peliculas.add(new Pelicula(3, "Titanic3", "Director3", 1998, 202));
//		for(int i = 0; i < peliculas.size(); i++) {
//			repo.createPelicula(peliculas.get(i));
//		}
//		peliculas.forEach(System.out::println);
		Pelicula pelicula = repo.getPeliculaById(1);
		System.out.println(pelicula);
		repo.deletePeliculaById(3);
	}

}
