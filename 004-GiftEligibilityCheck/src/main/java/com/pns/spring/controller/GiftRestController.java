package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.RequestBean;
import com.pns.spring.model.ResponseBean;
import com.pns.spring.service.GiftService;

@RestController
@RequestMapping("/gift")
public class GiftRestController {
	@Autowired
	GiftService giftService;
	
	@GetMapping("/")
	public String home() {
		return "WELCOME TO GIFT CHECKER";
	}
	
	@PostMapping("/check")
	public ResponseEntity<ResponseBean> giftChecker(@RequestBody RequestBean requestData) {
		return giftService.checkEligibles(requestData);
	}
	
}
