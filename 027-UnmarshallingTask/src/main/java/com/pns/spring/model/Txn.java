package com.pns.spring.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;

@Data
@XmlRootElement(name="Txn")
@XmlAccessorType(XmlAccessType.FIELD)
public class Txn {

	@XmlAttribute(name = "id")
    public String id;

	@XmlAttribute(name = "note")
    public String note;

	@XmlAttribute(name = "refId")
    public String refId;

	@XmlAttribute(name = "refUrl")
    public String refUrl;

	@XmlAttribute(name = "ts")
    public String ts;

	@XmlAttribute(name = "type")
    public String type;
	@XmlAttribute(name = "subType")
    public String subType;
	
	@XmlValue
	public String notRequiredVar="" ;

}
