package com.pns.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pns.spring.model.Order;
import com.pns.spring.model.OrderDto;
import com.pns.spring.model.PaymentDto;
import com.pns.spring.model.ResponseDto;
import com.pns.spring.model.TransactionDto;
import com.pns.spring.repo.OrderDao;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	OrderDao repository;

	@Autowired
	RestTemplate template;

	@Transactional
	public ResponseDto<TransactionDto> makeOrder(TransactionDto transactionDto) {
		OrderDto orderDto = transactionDto.getOrder();

		Order order = new Order();
		order.setName(orderDto.getName());
		order.setPrice(orderDto.getPrice());
		order.setQuantity(orderDto.getQuantity());

		order = repository.save(order);
		
		orderDto.setOrderId(order.getOrderId());
		
		ResponseEntity<PaymentDto> paymentResponse = template.postForEntity("http://PAYMENT-SERVICE/payment/doPayment",
				orderDto, PaymentDto.class);

		PaymentDto paymentDto = paymentResponse.getBody();
		
		transactionDto.setPayment(paymentDto);
		
		ResponseDto<TransactionDto> response = new ResponseDto<>();
		response.setData(transactionDto);
		response.setMessage("Payment "+paymentDto.getPaymentStatus());
		response.setStatus(HttpStatus.OK);
		return response;
	}
}
