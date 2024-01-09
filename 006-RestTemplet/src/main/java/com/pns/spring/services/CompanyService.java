package com.pns.spring.services;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pns.spring.model.CompanyDetailsDTO;
import com.pns.spring.model.CustomResponseDTO;
import com.pns.spring.model.EmployeeDTO;
import com.pns.spring.model.ResponseFromRestTempletDTO;

@Service
public class CompanyService {
	
	private static final String URI = "http://localhost:3133/project3/";
	public CompanyDetailsDTO getCompanyDetails(int id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseFromRestTempletDTO restTempletResponseObject = restTemplate.getForObject(URI+"get/"+id, ResponseFromRestTempletDTO.class);
		return new CompanyDetailsDTO("iserveu", restTempletResponseObject.getEmployee());
	}
	public ResponseEntity<CustomResponseDTO> postEmployee() {
		EmployeeDTO employee1 = new EmployeeDTO(1, "Priyabrata", "CEO");
		EmployeeDTO employee2 = new EmployeeDTO(2, "Chandan", "CTO");
		EmployeeDTO employee3 = new EmployeeDTO(3, "Sipak", "CFO");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
		HttpEntity<EmployeeDTO> entity = new HttpEntity<>(employee1, header);
		return restTemplate.postForEntity(URI+"save", entity, CustomResponseDTO.class, EmployeeDTO.class);
	}
}
