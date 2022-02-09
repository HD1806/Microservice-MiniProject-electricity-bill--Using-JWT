package com.example.demo.serviceiml;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MessageReponse;
import com.example.demo.dto.ReaderDto;
import com.example.demo.entity.CustomerModel;
import com.example.demo.entity.ReaderModel;
import com.example.demo.entity.UnitModel;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.ReaderRepo;
import com.example.demo.repo.UnitRepo;
import com.example.demo.security.JwtUtils;
import com.example.demo.service.ReaderService;

@Service
public class ReaderServiceIml implements ReaderService {

	@Autowired
	Environment env;

	@Autowired
	UnitRepo unitrepo;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	ReaderRepo readerrepo;

	@Autowired
	CustomerRepo customerrepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public ResponseEntity<?> save(ReaderDto readerdto) {
		try {
			if (readerdto.getRole().equalsIgnoreCase("ROLE_READER")) {
				ReaderModel model = ReaderModel.builder().readername(readerdto.getReadername())
						.email(readerdto.getEmail()).password(encoder.encode(readerdto.getPassword()))
						.role(readerdto.getRole()).build();
				readerrepo.save(model);
				return ResponseEntity.ok(new MessageReponse("Success", HttpStatus.OK.value(), model));
			}
		}

		catch (Exception e) {
			return ResponseEntity
					.ok(new MessageReponse(env.getProperty("errormessage"), HttpStatus.BAD_REQUEST.value()));
		}
		return ResponseEntity.ok(new MessageReponse(env.getProperty("errormessage"), HttpStatus.BAD_REQUEST.value()));
	}

	@Override
	public ResponseEntity<?> login(ReaderDto readerdto) {

		Optional<ReaderModel> record = readerrepo.findByemail(readerdto.getEmail());

		//String encryptedPassword = encoder.encode(readerdto.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(readerdto.getReadername(), readerdto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		// System.out.println("bearer token:" + jwt);
		record.get().setJwt(jwt);
		readerrepo.save(record.get());

		return ResponseEntity.ok(new MessageReponse("Success", HttpStatus.OK.value(), jwt));
	}

	@Override
	public List<CustomerModel> getall() {
		List<CustomerModel> modell = customerrepo.findAll();
		return modell;
	}

	@Override
	public ResponseEntity<?> updateunit(ReaderDto readerdto) {
		try {
			CustomerModel model1 = customerrepo.findByid(readerdto.getId());

			UnitModel unit = new UnitModel();
			unit.setReadertotalnoofunit(readerdto.getReadertotalnoofunit());
			// if(unit.getCusid().contains(readerdto.getCuid())) {
			unit.setCusid(model1.getId());

			// return ResponseEntity.ok( new
			// MessageReponse(env.getProperty("contains"),HttpStatus.BAD_REQUEST.value()));
			// }
			unitrepo.save(unit);

			return ResponseEntity.ok(new MessageReponse("Success", HttpStatus.OK.value(), unit));
		} catch (Exception e) {
			return ResponseEntity
					.ok(new MessageReponse(env.getProperty("updatemessage"), HttpStatus.BAD_REQUEST.value()));
		}
	}
}
