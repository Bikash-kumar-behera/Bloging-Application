package com.pns.spring.service;

import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.GetCustomerRequestDTO;

public interface TaskDec27Service {
	CustomerDTO saveCustomer(CustomerDTO customer);
	CustomerDTO getCustomer(GetCustomerRequestDTO get);
}
