package com.pns.spring.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "RespOtp")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespOtp  {

	@XmlElement(name = "Head")
	private Head Head;
	private Txn Txn;
	private Resp Resp;
	
}
