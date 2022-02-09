package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TokenDto;
import com.example.demo.entity.CustomerModel;

@Service
public interface TokenService {

	List<CustomerModel>getall();
	
	CustomerModel getbyid(TokenDto dto);
}
