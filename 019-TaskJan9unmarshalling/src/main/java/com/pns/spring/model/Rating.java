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
public class Rating {
	@NotNull(message = "Invalid verifiedAddress for Rating")
	@XmlAttribute(name = "VerifiedAddress")
	private VerifiedAddress verifiedAddress;

	@XmlEnum(String.class)
    public static enum VerifiedAddress {
        @XmlEnumValue("TRUE") TRUE,

        @XmlEnumValue("FALSE") FALSE
    }
}
