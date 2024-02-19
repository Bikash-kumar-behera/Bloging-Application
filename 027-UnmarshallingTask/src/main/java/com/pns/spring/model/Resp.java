package com.pns.spring.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Resp")
public class Resp {

	@XmlAttribute(name = "reqMsgId")
	private String reqMsgId;
	
	@XmlAttribute(name = "result")
	private String result;
	
	@XmlAttribute(name = "errCode")
	private String errCode;
	
	@XmlAttribute(name = "securePinUrl")
	private String securePinUrl;

}
