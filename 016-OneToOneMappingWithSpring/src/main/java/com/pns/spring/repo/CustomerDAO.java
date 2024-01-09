package com.pns.spring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.spring.model.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	Optional<Customer> findById(Integer id);
}
