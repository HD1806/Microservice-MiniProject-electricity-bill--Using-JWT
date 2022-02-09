package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.CustomerModel;
import com.example.demo.service.RegisterService;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {

	@Autowired
	RegisterService registerservice;

	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody RegisterDto register) {
		ResponseEntity<?> output = registerservice.register(register);
		return output;

	}

	@GetMapping(value = "/details", produces = "application/json")
	public CustomerModel get(@RequestBody RegisterDto dto) {
		CustomerModel output = registerservice.getbyid(dto);
		return output;

	}

}
