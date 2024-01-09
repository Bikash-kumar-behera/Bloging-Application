package com.pns.spring.bean;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDataBean {
	@JsonProperty("data")
	private String data;

	// all the extra fields other than "data" will be added to the map
	private Map<String,Object> additionalFields = new HashMap<>();

    @JsonAnySetter
    public void setAdditionalField(String key, Object value) {
        additionalFields.put(key, value);
    }
}