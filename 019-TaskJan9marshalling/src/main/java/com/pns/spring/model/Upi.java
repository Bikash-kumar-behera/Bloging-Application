package com.pns.spring.model;

import jakarta.validation.Valid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(namespace = "http://npci.org/upi/schema/", name = "ReqValAdd")
@XmlAccessorType(XmlAccessType.FIELD)
public class Upi {

    @XmlElement(name = "Head")
    private Head head;

    @XmlElement(name = "Txn")
    private Txn txn;

    @Valid
    @XmlElement(name = "Payer")
    private Payer payer;

    @XmlElement(name = "Payee")
    private Payee payee;
}