package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="readertable")
public class ReaderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String readername;
	private String email;
	private String password;
	private String jwt;
	private String role;
	

}
