package com.pns.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.pns.spring","com.pns.spring.*"})
public class GiftEligibilityCheck4Application {
	public static void main(String[] args) {
		SpringApplication.run(GiftEligibilityCheck4Application.class, args);
	}
}