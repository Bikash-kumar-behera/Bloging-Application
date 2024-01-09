package com.pns.spring.model;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pns.spring.util.Helper;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestDTO {

	@JsonProperty("customername")
	@Pattern(regexp = "[a-zA-z]+", message = "Invalid Name")
	@NotNull(message = "customername"+Helper.ERR_MSG)
	private String name;

	@JsonProperty("age")
	@NotNull(message = "age"+Helper.ERR_MSG)
	private Integer age;

	@JsonProperty("additionalfield")
	@NotNull(message = "addtionalfield"+Helper.ERR_MSG)
	@Valid
	private JSONObject additionalfield;

	@JsonProperty("location")
	@NotNull(message = "location"+Helper.ERR_MSG)
	private String location;
}
