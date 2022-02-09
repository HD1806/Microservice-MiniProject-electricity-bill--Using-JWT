package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StateCodeDto;

@Service
public interface StateCodeService {
	
	String save(StateCodeDto dto);

}
