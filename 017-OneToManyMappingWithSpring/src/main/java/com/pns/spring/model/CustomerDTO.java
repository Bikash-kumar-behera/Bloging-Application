package com.pns.spring.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_details_otm")
public class CustomerDTO {
	@Id
	@JsonProperty("id")
	@Column(name="cust_id")
	private int custId;
	
	@JsonProperty("name")
	@Column(name="cust_name")
	private String custName;
	
	@JsonProperty("age")
	@Column(name="cust_age")
	private int custAge;
	
	@JsonProperty("location")
	@Column(name="location")
	private String location;
	
	@Column(unique = true,name = "phone_number")
	@JsonProperty("phone")
	private long phoneNumber;
	
	@OneToMany(
			cascade = {CascadeType.ALL},
			fetch = FetchType.EAGER
			)
	@JoinColumn(name = "cc_join",referencedColumnName = "phone_number")
	@JsonProperty("cards")
	private Set<CardDTO> cards;
}
