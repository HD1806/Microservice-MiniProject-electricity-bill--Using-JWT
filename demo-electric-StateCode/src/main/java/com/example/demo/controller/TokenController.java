package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TokenDto;
import com.example.demo.entity.CustomerModel;
import com.example.demo.service.TokenService;

@RestController
@PreAuthorize(" hasRole('ROLE_READER')")
@RequestMapping("/api/token")
public class TokenController {
	
	@Autowired
	TokenService tokenservice;
	
	
	
	@GetMapping(value = "/byreadergetall", produces = "application/json")
	public List<CustomerModel> getall() {
		List<CustomerModel> output = tokenservice.getall();
		return output;

	}
	
	
	@GetMapping(value = "/details", produces = "application/json")
	public CustomerModel get(@RequestBody TokenDto dto) {
		CustomerModel output = tokenservice.getbyid(dto);
		return output;

	}

}
