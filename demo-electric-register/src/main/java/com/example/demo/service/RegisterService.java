package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.CustomerModel;

@Service
public interface RegisterService {
	
	ResponseEntity<?> register(RegisterDto register);
	
	CustomerModel getbyid(RegisterDto dto);
	
	

}
