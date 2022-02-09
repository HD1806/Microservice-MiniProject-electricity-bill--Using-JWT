package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterDto;

@Service
public interface PaymentService {
	
	String pay(RegisterDto registerdto);

}
