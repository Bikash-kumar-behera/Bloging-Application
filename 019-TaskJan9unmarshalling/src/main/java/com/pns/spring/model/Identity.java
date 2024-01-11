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
public class Identity {
	@XmlAttribute(name = "id")
	private String id;

	@NotNull(message = "Provide a valid Identity type")
	@XmlAttribute(name = "type")
	private IdentityType type;

	@XmlEnum(String.class)
    private static enum IdentityType{
        @XmlEnumValue("PAN") PAN,

        @XmlEnumValue("AADHAAR") AADHAAR,
        
        @XmlEnumValue("ACCOUNT") ACCOUNT;
        
    }

	@XmlAttribute(name = "verifiedName")
	private String verifiedName;
}
