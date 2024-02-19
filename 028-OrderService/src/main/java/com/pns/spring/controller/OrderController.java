package com.pns.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.ResponseDto;
import com.pns.spring.model.TransactionDto;
import com.pns.spring.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<ResponseDto<TransactionDto>> placeOrder(@RequestBody TransactionDto transactionDto) {
		ResponseDto<TransactionDto> response = orderService.makeOrder(transactionDto);
		return new ResponseEntity<>(response,response.getStatus());
	}
	
	@GetMapping("/home")
	public String orderHomePage() {
		return "Order Home Page";
	}
	
	
}
