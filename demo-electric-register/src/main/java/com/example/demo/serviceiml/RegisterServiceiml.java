package com.example.demo.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MessageReponse;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.CustomerModel;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.RegisterService;

@Service
public class RegisterServiceiml implements RegisterService {

	@Autowired
	Environment env;

	@Autowired
	CustomerRepo customerrepo;

	@Override
	public ResponseEntity<?> register(RegisterDto register) {
		// CustomerModel modell=
		CustomerModel model = CustomerModel.builder().name(register.getName()).location(register.getLocation())
				.totalnoofunit(register.getTotalnoofunit()).amount(register.getTotalnoofunit() * 3 - 300)
				.email(register.getEmail()).password(register.getPassword()).build();
		if (model.getTotalnoofunit() < 100) {
			return ResponseEntity.ok(new MessageReponse(env.getProperty("paymessage"), HttpStatus.BAD_REQUEST.value()));
		}
		if (model.getTotalnoofunit() > 200) {
			model.setAmount(register.getTotalnoofunit() * 7 - 300);
		}
		customerrepo.save(model);

		return ResponseEntity.ok(new MessageReponse("Success", HttpStatus.OK.value(), model));
	}

	@Override
	public CustomerModel getbyid(RegisterDto dto) {
		CustomerModel model1 = customerrepo.findByid(dto.getId());
		return model1;
	}
}
