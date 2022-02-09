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
@Table(name="paytable")
public class PayMentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
private int payamount;

//@OneToOne(mappedBy="paymentmodel")
//@JoinColumn(name = "Customer_id", referencedColumnName = "id")
//
//private CustomerModel customer;

}
