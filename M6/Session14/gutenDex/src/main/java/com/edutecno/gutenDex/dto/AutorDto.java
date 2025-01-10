package com.edutecno.gutenDex.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class AutorDto {
	private String name;
	@JsonAlias("birth_year") private int fechaDeNacimiento;
	@JsonAlias("death_year") private int fechaDeDeceso;
}
