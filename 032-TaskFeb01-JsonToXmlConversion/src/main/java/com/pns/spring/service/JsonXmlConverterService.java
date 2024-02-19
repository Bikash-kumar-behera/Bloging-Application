package com.pns.spring.service;

public interface JsonXmlConverterService {

	String convertJsonToXml(String jsonString);

	String convertXmlToJson(String xmlString);
}
