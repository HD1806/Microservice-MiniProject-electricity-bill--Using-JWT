package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PayMentModel;

@Repository
public interface PaymentRepo extends JpaRepository<PayMentModel, Integer>{

}
