package com.pns.spring.model;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Device {
	@Valid
    @XmlElement(name = "Tag")
	List<Tag> tags;
}
