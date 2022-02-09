package com.example.demo.iml;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CustomerModel;
import com.example.demo.entity.ReaderModel;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.ReaderRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	//@Autowired
	//CustomerRepo Repository;
//	@Autowired
//	AdminRepo adminRepo;
	
	@Autowired
	ReaderRepo Repository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String readername) throws UsernameNotFoundException {
		Optional<ReaderModel> user = Repository.findByreadername(readername);
				//Optional<AdminModel> admin= adminRepo.findByusername(name);
			if(user.isPresent()) {
				return UserDetailsImpl.build(user.get());

			}
//			else if(admin.isPresent()) {
//				return UserDetailsImpl.build(admin.get());
//
//			} else {
				throw new UsernameNotFoundException("User Not Found with username: " + readername);
			}
		
	}

//}

