package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseDTO {
	private String description;
	@JsonProperty("cust_id")
	private String customerId;
}

