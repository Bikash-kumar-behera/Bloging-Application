package com.pns.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.ResponseDTO;

@Service
public class ConsumerService {
//	private static final String BASE_URL = "http://10.255.255.1:31371/save";
	private static final String BASE_URL = "http://localhost:31371/save";

	@Autowired
	RestTemplate restTemplate;

	// While consuming an URL Content-Length is set dynamically after first request
	// For the next URL throw RestTemplate if you again post the same header make sure to remove the Content-Length

	public ResponseEntity<ResponseDTO> saveCustomer(CustomerDTO customer, HttpHeaders headers) {
		headers.remove("Content-Length");
		HttpEntity<CustomerDTO> entity = new HttpEntity<>(customer, headers);
		ResponseEntity<ResponseDTO> response;
		try {
//			response = restTemplate.postForEntity(BASE_URL, entity, ResponseDTO.class);
			
			ResponseDTO responseDTO = restTemplate.postForObject(BASE_URL, entity, ResponseDTO.class);
			response = new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
			
		} catch (HttpClientErrorException exception) {
			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setDescription(exception.getResponseBodyAs(ResponseDTO.class).getDescription());
			response = new ResponseEntity<>(responseDTO, exception.getStatusCode());
		}
		return response;
	}
}
