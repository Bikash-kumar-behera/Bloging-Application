package com.pns.spring.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "Payer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payer {
	
	@XmlAttribute(name = "addr")
	private String addr;
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "seqNum")
	private String seqNum;

	@NotNull(message = "provide a valid Payer type")
	@XmlAttribute(name = "type")
	private PayerType type;

	@XmlEnum(String.class)
    public static enum PayerType {
        @XmlEnumValue("PERSON") PERSON,
        
        @XmlEnumValue("ENTITY") ENTITY
    }

	@XmlAttribute(name = "code")
	private String code;
	
	@Valid
	@XmlElement(name = "Info")
	private Info info;
	
	@Valid
	@XmlElement(name = "Device")
	private Device device;
}
