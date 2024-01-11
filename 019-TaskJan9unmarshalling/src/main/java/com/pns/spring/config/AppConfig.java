package com.pns.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pns.spring.service.TaskJan9Service;
import com.pns.spring.service.impl.TaskJan9ServiceImpl1;
import com.pns.spring.service.impl.TaskJan9ServiceImpl2;

@Configuration
public class AppConfig {
	@Bean(name = "TaskJan9ServiceImpl1")
	TaskJan9Service getService1() {
		return new TaskJan9ServiceImpl1();
	}
	
	@Bean(name = "TaskJan9ServiceImpl2")
	TaskJan9Service getService2() {
		return new TaskJan9ServiceImpl2();
	}
}