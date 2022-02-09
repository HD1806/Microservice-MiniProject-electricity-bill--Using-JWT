package com.example.demo.dto;

import lombok.Data;

@Data
public class MessageReponse {

	private int status;
	private String message;
	private Object response;

	public MessageReponse(String message, int status, Object response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}

	public MessageReponse(String message, int status) {
		super();
		this.status = status;
		this.message = message;
	}

}
