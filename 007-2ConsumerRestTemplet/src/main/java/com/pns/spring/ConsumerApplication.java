package com.pns.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Bean
	RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory httpRequestFactory = 
				(SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		httpRequestFactory.setConnectTimeout(5000);
		return restTemplate;
	}
}
