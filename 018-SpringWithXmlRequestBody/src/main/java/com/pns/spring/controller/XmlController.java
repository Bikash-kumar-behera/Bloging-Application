package com.pns.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.models.RequestDTO;
import com.pns.spring.models.ResponseDTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

@RestController
@Validated
public class XmlController {
	@PostMapping(path = "post", consumes = "application/xml",produces = "application/xml")
	public ResponseEntity<ResponseDTO<RequestDTO>> post(@Valid @RequestBody RequestDTO requestDTO) {
		System.out.println(requestDTO);
		ResponseDTO<RequestDTO> response = new ResponseDTO<>();
		response.setData(requestDTO);
		response.setStatus(HttpStatus.OK);
		response.setMessage("Successful request");
		return new ResponseEntity<>(response,response.getStatus());
	}
	
	@GetMapping(path = "get",produces = MediaType.APPLICATION_XML)
	public ResponseDTO<RequestDTO> getMethodName() {
		ResponseDTO<RequestDTO> response = new ResponseDTO<>();
		RequestDTO requestDTO = new RequestDTO(100,"Harish","harish@gmail.com");
		response.setData(requestDTO);
		response.setMessage("SuccessFul");
		response.setStatus(HttpStatus.OK);
		return response;
	}
}
