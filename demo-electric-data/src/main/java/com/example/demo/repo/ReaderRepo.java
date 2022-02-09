package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReaderModel;

@Repository
public interface ReaderRepo extends JpaRepository<ReaderModel, Integer>{

	Optional<ReaderModel> findByreadername(String readername);

	Optional<ReaderModel> findByemail(String email);

}
