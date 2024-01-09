package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestDTO {

	@NotNull(message = "Customer ID cannot be Empty")
	@JsonProperty("id")
	private Integer custId;

	@NotNull(message = "Customer Name cannot be Empty")
	@JsonProperty("name")
	private String custName;

	@JsonProperty("card")
	private Card card;

}
