package com.pns.spring.service;

import com.pns.spring.model.Customer;
import com.pns.spring.model.RequestDTO;
import com.pns.spring.model.ResponseDTO;

public interface CustomerService {
	ResponseDTO<Customer> saveCustomer(RequestDTO customer);
	ResponseDTO<Customer> getCustomer(Integer id);
	ResponseDTO<Customer> updateCustomer(Integer id, RequestDTO customer);
	ResponseDTO<Customer> deleteCustomer(Integer id);
}
