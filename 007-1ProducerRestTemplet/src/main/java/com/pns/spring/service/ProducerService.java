package com.pns.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.spring.model.CustomerDTO;
import com.pns.spring.repo.ProducerDAO;

@Service
public class ProducerService {
	@Autowired
	ProducerDAO producerDAO;
	
	public String storeCustomer(CustomerDTO customer) {
		return producerDAO.save(customer);
	}
}
