package com.pns.spring.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Component
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ResponseBean {
	
	@Getter
	@Setter
	@JsonProperty(value = "selectedemp")
	private List<EligibleEmployeeBean> selectedEmployeeList;
	
}
