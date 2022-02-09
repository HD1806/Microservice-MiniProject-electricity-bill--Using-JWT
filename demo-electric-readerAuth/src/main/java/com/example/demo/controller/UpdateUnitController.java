package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReaderDto;
import com.example.demo.service.ReaderService;

@RestController
@RequestMapping("/api/auths/reader")
@PreAuthorize(" hasRole('ROLE_READER')")
public class UpdateUnitController {

	@Autowired
	ReaderService readerservice;

	@PostMapping(value = "/updateunit", produces = "application/json")
	public ResponseEntity<?> updateunit(@RequestBody ReaderDto readerdto) {
		ResponseEntity<?> output = readerservice.updateunit(readerdto);
		return output;

	}

}
