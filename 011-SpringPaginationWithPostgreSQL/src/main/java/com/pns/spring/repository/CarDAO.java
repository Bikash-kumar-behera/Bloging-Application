package com.pns.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pns.spring.model.CarDTO;

@Repository
public interface CarDAO extends JpaRepository<CarDTO, Integer>{
	
}
