package com.pns.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
	@Id
	private int cardId;
	
	private int cvv;
	
//	@OneToOne
//	@JoinColumn(name = "cust_id")
//	private Customer customer;
	
}
