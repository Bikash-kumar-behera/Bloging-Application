package com.pns.spring.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JacksonXmlRootElement(localName = "student")
public class RequestDTO {

	@NotNull(message = "id cannnot be null")
	@JacksonXmlProperty(localName = "sid")
	private int id;

	@NotNull(message = "name cannnot be null")
	@JacksonXmlElementWrapper(localName = "sname")
	private String name;

	@NotNull(message = "email cannnot be null")
	@JacksonXmlElementWrapper(localName = "email")
	private String email;
}
