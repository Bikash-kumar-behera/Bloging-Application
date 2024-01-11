package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.ReqValAdd;
import com.pns.spring.service.TaskJan9Service;

import jakarta.validation.Valid;

@RestController
@Validated
public class TaskJan9Controller {
	@Autowired
	@Qualifier("TaskJan9ServiceImpl1")
	TaskJan9Service service;
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE, path = "post")
	public ReqValAdd unmarshalling(@Valid @RequestBody ReqValAdd reqValAdd) {
		return service.getReqValAdd(reqValAdd);
	}
}
