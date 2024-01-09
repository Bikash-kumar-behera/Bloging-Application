package com.pns.spring.service;

import java.util.List;

import com.pns.spring.model.CardDTO;
import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.ResponseDTO;

public interface OneToManyService {
	
	ResponseDTO<CustomerDTO> saveCustomer(CustomerDTO customerDTO);
	ResponseDTO<List<CardDTO>> getAllCards(long phoneNumber);
	
}
