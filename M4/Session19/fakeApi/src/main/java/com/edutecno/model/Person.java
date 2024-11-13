package com.edutecno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(
		Gender gender,
		String email,
		String phone,
		String nat,
		Name name,
		Location location,
		Login login
		) {}
