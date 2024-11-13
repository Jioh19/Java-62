package com.edutecno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Location(
		String city,
		String state,
		String country
		) {

}
