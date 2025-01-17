package com.edutecno.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutecno.demo.model.BackgroundRequest;
import com.edutecno.demo.model.BackgroundResponse;
import com.edutecno.demo.service.BackgroundResponseService;

@Controller
@RequestMapping("/api/background")
public class BackgroundController {

	@Autowired
	BackgroundResponseService service;
	
	@PostMapping
	public ResponseEntity<BackgroundResponse> remove(
			@RequestBody BackgroundRequest request) {
		BackgroundResponse response = service.remove(request);
		return ResponseEntity.ok(response);
	}
}
