package com.pns.spring.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Payee {
	
	@XmlAttribute(name = "seqNum")
	private String seqNum;
	
	@XmlAttribute(name = "addr")
	private String addr;
}
