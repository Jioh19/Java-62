package com.edutecno.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edutecno.demo.model.BackgroundRequest;
import com.edutecno.demo.model.BackgroundResponse;

@Service
public class BackgroundResponseService {
	@Autowired
	RestTemplate restTemplate;

	private final String API_URL = "https://ai-background-remover-best.p.rapidapi.com/api-remove-bg";
	private final String API_KEY = "API_KEY";
	private final String API_HOST = "ai-background-remover-best.p.rapidapi.com";

	public BackgroundResponse remove(BackgroundRequest request) {


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-rapidapi-host", API_HOST);
		headers.set("x-rapidapi-key", API_KEY);

		Map<String, String> jsonRequest = new HashMap<>();
        jsonRequest.put("image_url", request.getUrl_image());
		
		HttpEntity<Map<String, String>> requestEntity = 
				new HttpEntity<>(jsonRequest, headers);
		
		ResponseEntity<BackgroundResponse> response = restTemplate.exchange(
				API_URL,
				HttpMethod.POST,
				requestEntity,
				BackgroundResponse.class);
		
		return response.getBody();
	}
}
