package com.example.demo.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterDto {
	private String id;
	private String name;
	private String location;
	private String email;
	private String password;
	private int totalnoofunit;
	private long amount;
	private String paidstatus;

	private int payamount;

	private String district;
	private int datareferenceid;

	private int readertotalnoofunit;

}
