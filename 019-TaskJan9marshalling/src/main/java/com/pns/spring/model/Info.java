package com.pns.spring.model;

import jakarta.validation.Valid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Info {
	
	@Valid
	@XmlElement(name = "Identity")
	private Identity identity;

	@Valid
	@XmlElement(name = "Rating")
	private Rating rating;
}