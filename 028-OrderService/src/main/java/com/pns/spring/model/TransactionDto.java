package com.pns.spring.model;

import lombok.Data;

@Data
public class TransactionDto {
	OrderDto order;
	PaymentDto payment;
}
