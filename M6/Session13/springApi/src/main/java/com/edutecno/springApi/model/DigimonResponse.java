package com.edutecno.springApi.model;

import java.util.List;

import lombok.Data;

@Data
public class DigimonResponse {
	private List<DigimonGeneralResponse> content;
}
