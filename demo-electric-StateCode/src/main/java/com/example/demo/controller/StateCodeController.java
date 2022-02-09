package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StateCodeDto;
import com.example.demo.service.StateCodeService;

@RestController


public class StateCodeController {
	
	@Autowired
	StateCodeService statecodeservice;
	
	
	@PostMapping(value="/saveRefCode",produces="application/json")
	public String save(@RequestBody StateCodeDto stateCodeDto) {
		String output=statecodeservice.save(stateCodeDto);
		return output;
		
	}

}
