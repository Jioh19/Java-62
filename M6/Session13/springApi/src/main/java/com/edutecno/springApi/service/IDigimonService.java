package com.edutecno.springApi.service;

import com.edutecno.springApi.model.Digimon;
import com.edutecno.springApi.model.DigimonResponse;

public interface IDigimonService {
	DigimonResponse findAll();
	Digimon findById(Integer id);
}
