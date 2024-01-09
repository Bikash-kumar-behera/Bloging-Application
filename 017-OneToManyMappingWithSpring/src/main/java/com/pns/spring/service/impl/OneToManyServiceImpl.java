package com.pns.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pns.spring.model.CardDTO;
import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.repo.CardDAO;
import com.pns.spring.repo.CustomerDAO;
import com.pns.spring.service.OneToManyService;

@Service
public class OneToManyServiceImpl implements OneToManyService {

	@Autowired
	CustomerDAO customerRepository;
	
	@Autowired
	CardDAO cardRepository;
	
	@Override
	public ResponseDTO<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
		ResponseDTO<CustomerDTO> response = new ResponseDTO<>();
		try {
			customerRepository.save(customerDTO);
			response.setStatus(HttpStatus.OK);
			response.setMessage("Successfully Saved to DB");
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("Something went wrong");
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ResponseDTO<List<CardDTO>> getAllCards(long phoneNumber) {
//		Optional<List<CardDTO>> optional = cardRepository.findCardsByMobileNumber(phoneNumber);
		Optional<List<CardDTO>> optional = cardRepository.findCardsByMobileNumber(phoneNumber);
		ResponseDTO<List<CardDTO>> response = new ResponseDTO<>();
		if(optional.isPresent() &&  optional.get().size()!=0) {
			response.setData(optional.get());
			response.setMessage(optional.get().size()+" linked cards found.");
			response.setStatus(HttpStatus.OK);
		}else {
			response.setMessage("No linked cards found.");
			response.setStatus(HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
