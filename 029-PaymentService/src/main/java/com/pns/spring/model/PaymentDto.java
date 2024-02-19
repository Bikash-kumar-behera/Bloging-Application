package com.pns.spring.model;

import lombok.Data;

@Data
public class PaymentDto {
	private int paymentId;
	private double amount;
	private int orderId;
	private String transactionId;
	private String paymentStatus;
}
