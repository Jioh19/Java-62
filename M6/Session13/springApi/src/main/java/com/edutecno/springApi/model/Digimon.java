package com.edutecno.springApi.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Digimon {
	private Integer id;
	private String name;
	private String releaseDate;
	private boolean xAntibody;
	private List<DigimonImagen> images;
}
