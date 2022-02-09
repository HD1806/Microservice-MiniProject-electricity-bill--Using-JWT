package com.example.demo.dto;

import lombok.Data;

@Data
public class ReaderDto {

	
	private String id;

	private String readername;
	private String jwt;
	private String role;
	private String email;
	private String password;
    private int totalnoofunit;
    
    
    private int rid;
	private int readertotalnoofunit;
	
	private String cuid;
    
    
	
}
