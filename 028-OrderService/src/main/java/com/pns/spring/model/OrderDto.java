package com.pns.spring.model;

import lombok.Data;

@Data
public class OrderDto {
	private int orderId;
	private String name;
	private int quantity;
	private double price;
}
