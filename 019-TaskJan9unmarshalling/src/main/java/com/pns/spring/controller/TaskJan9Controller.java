package com.pns.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.ReqValAdd;

import jakarta.validation.Valid;

@RestController
@Validated
public class TaskJan9Controller {
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE, path = "post")
	public ReqValAdd unmarshalling(@Valid @RequestBody ReqValAdd reqValAdd) {
		return reqValAdd;
	}
}
