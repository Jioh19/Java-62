package com.edutecno.gutenDex.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class LibroDto {
	private int id;
	private String title;
	@JsonAlias("download_count") private int descargas;
	@JsonAlias("authors") private List<AutorDto> autores;
}
