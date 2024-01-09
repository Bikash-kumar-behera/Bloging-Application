package com.pns.spring.model;

import java.util.Map;

import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_details")
public class CustomerDTO {
	
	@Id
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "pincode", nullable = false)
	private long pincode;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Type(value = JsonType.class)
	@Column(name = "additionalfield", columnDefinition = "JSON")
	private Map<String,String> additionalField;
	
}
