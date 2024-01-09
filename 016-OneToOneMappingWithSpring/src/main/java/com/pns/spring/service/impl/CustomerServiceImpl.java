package com.pns.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pns.spring.model.Customer;
import com.pns.spring.model.RequestDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.repo.CustomerDAO;
import com.pns.spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerRepository;

	@Autowired
	ResponseDTO<Customer> responseDTO;

	@Override
	public ResponseDTO<Customer> saveCustomer(RequestDTO request) {
		responseDTO.setData(null);
		Customer customer = new Customer();
		customer.setCustId(request.getCustId());
		customer.setCustName(request.getCustName());
		customer.setCard(request.getCard());
		if (customerRepository.save(customer) != null) {
			responseDTO.setData(customer);
			responseDTO.setStatus(HttpStatus.OK);
		}else {
			responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO<Customer> getCustomer(Integer id) {
		responseDTO.setData(null);
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent())
		{
			responseDTO.setStatus(HttpStatus.OK);
			responseDTO.setData(customer.get());
		}else {
			responseDTO.setStatus(HttpStatus.NOT_FOUND);
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO<Customer> updateCustomer(Integer id, RequestDTO requestDTO) {
		responseDTO.setData(null);
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			Customer existingCustomer = optional.get();
			existingCustomer.setCustId(requestDTO.getCustId());
			existingCustomer.setCard(requestDTO.getCard());
			existingCustomer.setCustName(requestDTO.getCustName());
			customerRepository.deleteById(id);
			customerRepository.save(existingCustomer);
			responseDTO.setStatus(HttpStatus.OK);
			responseDTO.setData(existingCustomer);
		}else {
			responseDTO.setStatus(HttpStatus.NOT_FOUND);
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO<Customer> deleteCustomer(Integer id) {
		responseDTO.setData(null);
		if(customerRepository.existsById(id)) {
			responseDTO.setStatus(HttpStatus.OK);
			customerRepository.deleteById(id);
		}else {
			responseDTO.setStatus(HttpStatus.NOT_FOUND);
		}
		return responseDTO;
	}
	

}
