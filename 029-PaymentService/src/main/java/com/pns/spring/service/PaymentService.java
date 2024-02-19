package com.pns.spring.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.spring.model.OrderDto;
import com.pns.spring.model.Payment;
import com.pns.spring.model.PaymentDto;
import com.pns.spring.repo.PaymentDao;

@Service
public class PaymentService {
	
	@Autowired
	PaymentDao repository;
	
	public PaymentDto makePayment(OrderDto order){
		Payment payment = new Payment();
		payment.setAmount(order.getPrice()*order.getQuantity());
		payment.setOrderId(order.getOrderId());
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());		
		repository.save(payment);
		
		System.out.println(payment);
		
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setPaymentId(payment.getPaymentid());
		paymentDto.setAmount(payment.getAmount());
		paymentDto.setOrderId(payment.getOrderId());
		paymentDto.setTransactionId(payment.getTransactionId());
		paymentDto.setPaymentStatus(payment.getPaymentStatus());
		
		return paymentDto;
	}
	
	
	public String paymentProcessing() {
		//actual call is 3rd party payment gateway
		return new Random().nextBoolean()?"SUCCESS":"FAILED";
	}
}
