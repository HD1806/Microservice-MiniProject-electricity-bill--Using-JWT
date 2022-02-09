package com.example.demo.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TokenDto;
import com.example.demo.entity.CustomerModel;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.TokenService;

@Service
public class TokenServiceIml implements TokenService{
	
	@Autowired
	CustomerRepo customerrepo;

	

	@Override
	public List<CustomerModel> getall() {
		List<CustomerModel>modell=customerrepo.findAll();

		return modell;
	}



	@Override
	public CustomerModel getbyid(TokenDto dto) {
		CustomerModel model1 = customerrepo.findByid(dto.getId());
		return model1;
	}

}
