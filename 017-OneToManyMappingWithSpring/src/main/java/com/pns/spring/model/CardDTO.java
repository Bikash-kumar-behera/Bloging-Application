package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "card_details_otm")
public class CardDTO {
	@Id
	@JsonProperty("id")
	@Column(name="card_id")
	private int cardId;

	@Column(unique = true, name = "card_number")
	@JsonProperty("card_number")
	private long cardNo;
	
	@JsonProperty("card_limit")
	@Column(name="card_limit")
	private int cardLimit;
	
	@JsonProperty("txn_limit")
	@Column(name="txn_limit")
	private int txnLimit;
}
