package com.pns.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pns.spring.service.ProductService;
import com.pns.spring.service.ReviewService;
import com.pns.spring.service.impl.ProductServiceImpl;
import com.pns.spring.service.impl.ReviewServiceImpl;

@Configuration
public class AppConfiguration {
	
	
	@Bean
	ProductService getProductService() {
		return new ProductServiceImpl();
	}
	
	@Bean
	ReviewService getReviewService() {
		return new ReviewServiceImpl();
	}
	
}
