package com.pns.spring.service;

import org.springframework.stereotype.Service;

import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.GetCustomerRequestDTO;

@Service
public interface TaskDec27Service {
	CustomerDTO saveCustomer(CustomerDTO customer);
	CustomerDTO getCustomer(GetCustomerRequestDTO get);
}
