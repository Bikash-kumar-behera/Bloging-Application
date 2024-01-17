package com.pns.spring;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pns.spring.model.EncryptedDto;
import com.pns.spring.service.SecretUtilsService;

@SpringBootApplication
public class Application {
	
	private final static String BASE64_KEY = "XHgxl8qs5D6sejZncSsYg7OqPIeV0uQe5I9Zh+uHLcc=";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://172.16.2.114:3001/api/v1/decryption";
		
		Map<String,String> map = new HashMap<>();
		map.put("channel", "ANDROID");
		map.put("userName", "CUST7978628756");
		ResponseEntity<EncryptedDto> responseEntity =  restTemplate.postForEntity(baseUrl, SecretUtilsService.aesGcmEncryptToBase64(BASE64_KEY, map), EncryptedDto.class);
		EncryptedDto encryptedResponse = responseEntity.getBody();
		JSONObject data = (JSONObject) SecretUtilsService.aesGcmDecryptFromBase64(BASE64_KEY, encryptedResponse);
		System.out.println(data.toJSONString());
	}
	
}
