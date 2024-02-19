package com.pns.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_tbl")
public class Payment {
	@Id
	@GeneratedValue
	private int paymentid;
	private String paymentStatus;
	private String transactionId;
	private int orderId;
	private double amount;
}
