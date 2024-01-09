package com.pns.spring.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	private int custId;
	private String custName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card_id")
	private Card card;
}
