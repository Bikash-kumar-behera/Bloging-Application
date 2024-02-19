package com.pns.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@GetMapping("/orderFallBack")
	@HystrixProperty(name = "", value = "")
	Mono<String> orderFallBack() {
		return Mono.just("Order service is down");
	}
	@GetMapping("/paymentFallBack")
	Mono<String> paymentFallBack() {
		return Mono.just("Payment service is down");
	}
	
}
