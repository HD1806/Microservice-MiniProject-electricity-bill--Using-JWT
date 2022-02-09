package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerModel;
import com.example.demo.entity.ReaderModel;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, String>{

	//Optional<CustomerModel> findByname(String name);

	CustomerModel findByid(String id);



	
	//Optional<ReaderModel> findByreadername(String name);
	          

}
