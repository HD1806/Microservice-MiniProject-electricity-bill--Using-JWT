package com.example.demo.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StateCodeDto;
import com.example.demo.entity.StateCodeModel;
import com.example.demo.repo.StateModelRepo;
import com.example.demo.service.StateCodeService;


@Service
public class StateCodeServiceIml implements StateCodeService{
	
	@Autowired
	StateModelRepo staterepo;

	@Override
	public String save(StateCodeDto dto) {
		StateCodeModel model=new StateCodeModel();
		model.setDistrict(dto.getDistrict());
		model.setReferenceid(dto.getReferenceid());
		staterepo.save(model);
		
	
		return "successfully saved";
	}

}
