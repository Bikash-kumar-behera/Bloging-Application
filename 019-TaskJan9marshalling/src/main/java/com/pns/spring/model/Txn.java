package com.pns.spring.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Txn {
	@XmlAttribute(name = "id")
	private String id;
	
	@XmlAttribute(name = "note")
	private String note;
	
	@XmlAttribute(name = "refId")
	private String refId;
	
	@XmlAttribute(name = "refUrl")
	private String refUrl;
	
	@XmlAttribute(name = "ts")
	private String ts;
	
	@XmlAttribute(name = "type")
	private String type;
}
