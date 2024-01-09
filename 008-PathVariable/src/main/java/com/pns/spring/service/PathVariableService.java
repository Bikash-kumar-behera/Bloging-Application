package com.pns.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pns.spring.model.EmployeeDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.repository.EmployeeDAO;

@Service
public class PathVariableService {

	@Autowired
	EmployeeDAO employeeRepo;
	
	public ResponseEntity<ResponseDTO> getEmployee(int id) {
		EmployeeDTO employeeDTO = employeeRepo.getEmployee(id);
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setId(id);
		responseDTO.setEmployee(employeeDTO);
		String message = employeeDTO!=null?"Employee Details Fetched":"Employee Not Found";
		HttpStatus status = employeeDTO!=null?HttpStatus.OK:HttpStatus.NOT_FOUND;
		responseDTO.setMessage(message);
		ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO,status);
		return response;
	}

}
