package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UnitModel;

@Repository
public interface UnitRepo extends JpaRepository<UnitModel, Integer>{

	UnitModel findByreadertotalnoofunit(int readertotalnoofunit);

	UnitModel findBycusid(String cuid);

}
