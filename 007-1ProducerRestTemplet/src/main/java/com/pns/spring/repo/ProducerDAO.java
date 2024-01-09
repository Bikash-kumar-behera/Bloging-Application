package com.pns.spring.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.pns.spring.model.CustomerDTO;

@Repository
public class ProducerDAO {
	Map<String, CustomerDTO> customerList;
	public ProducerDAO() {
		if(customerList==null)
			customerList= new HashMap<>();
	}
	public String save(CustomerDTO customer) {
		String customerId = UUID.randomUUID().toString();
		customerList.put(customerId, customer);
		return customerId;
	}
}
