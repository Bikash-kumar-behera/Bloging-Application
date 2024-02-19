package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.OrderDto;
import com.pns.spring.model.PaymentDto;
import com.pns.spring.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public ResponseEntity<PaymentDto> doPayment(@RequestBody OrderDto order) {
		PaymentDto paymentDto = paymentService.makePayment(order);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(paymentDto,status);
	}
	
	@GetMapping("/home")
	public String paymentHomePage() {
		return "Payment Home Page";
	}
	
}
