package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegisterDto;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/api/auth")

public class PaymentController {
	@Autowired
	PaymentService paymentservice;

	@PostMapping(value = "/pay", produces = "application/json")
	public String payed(@RequestBody RegisterDto register) {
		String output = paymentservice.pay(register);
		return output;

	}

}
