package com.example.demo.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReaderDto;
import com.example.demo.entity.CustomerModel;

@Service
public interface ReaderService {
	
 ResponseEntity<?> save(ReaderDto readerdto);
 
 ResponseEntity<?>  login(ReaderDto readerdto);
 
 List<CustomerModel>getall();
 
 ResponseEntity<?> updateunit(ReaderDto readerdto);
	
}
