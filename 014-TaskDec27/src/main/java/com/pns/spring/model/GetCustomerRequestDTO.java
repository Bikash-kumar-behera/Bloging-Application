package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GetCustomerRequestDTO {
	
	@JsonProperty("customername")
	@NotNull(message = "customername field should not be blank")
	@Pattern(regexp = "[a-zA-Z]+",message = "Invalid name format")
	private String customername;
	
	@JsonProperty("location")
	@NotNull(message = "location field should not be blank")
	private String location;
	
	@JsonProperty("051")
	@NotNull(message = "051 field should not be blank")
	private String additionalField;
	
}
