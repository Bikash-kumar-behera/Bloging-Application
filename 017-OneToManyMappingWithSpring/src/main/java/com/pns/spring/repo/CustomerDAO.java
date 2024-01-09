package com.pns.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.spring.model.CustomerDTO;

public interface CustomerDAO extends JpaRepository<CustomerDTO, Integer>{
}
