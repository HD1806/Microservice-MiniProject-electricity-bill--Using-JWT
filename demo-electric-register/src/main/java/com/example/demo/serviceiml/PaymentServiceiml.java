package com.example.demo.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.CustomerModel;
import com.example.demo.entity.PayMentModel;
import com.example.demo.entity.StateCodeModel;
import com.example.demo.entity.UnitModel;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.PaymentRepo;
import com.example.demo.repo.StateModelRepo;
import com.example.demo.repo.UnitRepo;
import com.example.demo.service.PaymentService;

@Service

public class PaymentServiceiml implements PaymentService {

	@Autowired
	StateModelRepo statemodel;

	@Autowired
	UnitRepo unitrepo;

	@Autowired
	CustomerRepo customerrepo;

	@Autowired
	PaymentRepo paymentrepo;

	@Override
	public String pay(RegisterDto registerdto) {

		CustomerModel modell = customerrepo.findById(registerdto.getId()).get();

		UnitModel mm = unitrepo.findByreadertotalnoofunit(registerdto.getReadertotalnoofunit());

		StateCodeModel RefCode = statemodel.findByreferenceid(registerdto.getDatareferenceid());

		PayMentModel pay = new PayMentModel();

		// PayMentModel
		// pay=PayMentModel.builder().payamount(modell.getAmount()==pay.getPayamount())
		// if(registerdto.getPayamount()==modell.getAmount())
		if (modell.getTotalnoofunit() == registerdto.getTotalnoofunit()
				&& mm.getReadertotalnoofunit() == registerdto.getReadertotalnoofunit()
				&& RefCode.getReferenceid() == registerdto.getDatareferenceid()) {
			pay.setPayamount(registerdto.getPayamount());
			modell.setPaidstatus("PAIDED");
			customerrepo.save(modell);
			paymentrepo.save(pay);
			return "Payment sucess";
		} else {
			return "not paid";
		}
	}
	// &&RefCode.getReferenceid()==registerdto.getDatareferenceid()

}
