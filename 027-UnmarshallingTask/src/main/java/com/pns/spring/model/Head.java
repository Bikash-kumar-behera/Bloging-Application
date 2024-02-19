package com.pns.spring.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "Head")
@XmlAccessorType(XmlAccessType.FIELD)
public class Head {

	@XmlAttribute(name = "ver")
	public String ver;
	
	@XmlAttribute(name = "ts")
	public String ts;
	
	@XmlAttribute(name = "orgId")
	public String orgId;
	
	@XmlAttribute(name = "msgId")
	public String msgId;
	
}
