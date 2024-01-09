package com.pns.spring.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Head {
	@XmlAttribute(name = "ver")
	private float ver;
	
	@XmlAttribute(name = "ts")
	private String ts;
	
	@XmlAttribute(name = "orgId")
	private String orgId;
	
	@XmlAttribute(name = "msgId")
	private String msgId;
}
