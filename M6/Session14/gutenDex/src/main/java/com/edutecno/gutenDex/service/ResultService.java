package com.edutecno.gutenDex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edutecno.gutenDex.dto.LibroDto;
import com.edutecno.gutenDex.dto.ResultDto;

@Service
public class ResultService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private String resourceUrl = "https://gutendex.com/books/";
	
	public List<LibroDto> getAll() {
		try {
			ResponseEntity<ResultDto> response = restTemplate.exchange(
					resourceUrl,
					HttpMethod.GET,
					null,
					ResultDto.class);
			return response.getBody().getResults();
		} catch(Exception e) {
			System.out.println("Error al traer el resultDto");
			return null;
		}
	}
}
