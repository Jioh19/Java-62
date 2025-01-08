package com.edutecno.springApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edutecno.springApi.model.Digimon;
import com.edutecno.springApi.model.DigimonResponse;

@Service
public class DigimonService implements IDigimonService {

	@Autowired
	RestTemplate restTemplate;

	String resourceUrl = "https://digi-api.com/api/v1/digimon";

	@Override
	public DigimonResponse findAll() {

		ResponseEntity<DigimonResponse> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<DigimonResponse>() {
				});
		return response.getBody();
	}

	@Override
	public Digimon findById(Integer id) {
		ResponseEntity<Digimon> response = restTemplate.exchange(resourceUrl + " /" + id, HttpMethod.GET,
				HttpEntity.EMPTY, new ParameterizedTypeReference<Digimon>() {
				});
		return response.getBody();

	}

}
