package com.pns.spring.model;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {
	@XmlAttribute(name = "name")
	private String name;
	
	@NotNull(message = "Invalid Tag value")
	@XmlAttribute(name = "value")
	private TagValue value;
	
	@XmlEnum(String.class)
	private enum TagValue{
		@XmlEnumValue("VODAFONE") VODAFONE,
		@XmlEnumValue("IDEA") IDEA,
		@XmlEnumValue("JIO") JIO,
		@XmlEnumValue("AIRTEL") AIRTEL,
		@XmlEnumValue("DOCOMO") DOCOMO,
		@XmlEnumValue("") EMPTY,
		
	}
}
