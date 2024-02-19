package com.pns.spring.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class JsonXmlConverterController {

    @PostMapping("/jsonToXml")
    public String convertJsonToXml(@RequestBody Map<String, String> jsonData) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        
        // Convert JSON to XML
        String xmlData = xmlMapper.writeValueAsString(jsonData);

        return xmlData;
    }

    @PostMapping("/xmlToJson")
    public String convertXmlToJson(@RequestBody String xmlData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();
        
        // Convert XML to JSON
        Map<String,String> jsonData = xmlMapper.readValue(xmlData, Map.class);
        String jsonDataString = objectMapper.writeValueAsString(jsonData);

        return jsonDataString;
    }
	
}
