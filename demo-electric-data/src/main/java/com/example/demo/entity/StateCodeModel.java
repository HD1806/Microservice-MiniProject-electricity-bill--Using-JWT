package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="statecode")
public class StateCodeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String district;
	private int referenceid;

}
