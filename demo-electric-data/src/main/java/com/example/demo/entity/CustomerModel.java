package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customertable")
public class CustomerModel {
	
	@Id
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	private String id;
	private String name;
	private String location;
	private int totalnoofunit;
	private String email;
	private String password;
	private int amount;
	private String paidstatus;
	
//	@OneToOne
//	@JsonBackReference
//	private PayMentModel paymentmodel;
//	
	

}
