package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReaderDto;
import com.example.demo.entity.CustomerModel;
import com.example.demo.service.ReaderService;

@RestController
@RequestMapping("/api/auths/reader")
public class ReaderController {

	@Autowired
	ReaderService readerservice;

	@PostMapping(value = "/readerreg", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody ReaderDto readerdto) {
		ResponseEntity<?> output = readerservice.save(readerdto);
		return output;

	}

	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> login(@RequestBody ReaderDto readerdto) {
		ResponseEntity<?> output = readerservice.login(readerdto);
		return output;

	}

	@GetMapping(value = "/getall", produces = "application/json")
	public List<CustomerModel> getall() {
		List<CustomerModel> output = readerservice.getall();
		return output;

	}

}
