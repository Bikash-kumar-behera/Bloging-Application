package com.pns.firstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pns.firstspring.beans.ComponentBeanTest;

@SpringBootApplication
public class FirstProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.pns.firstspring.beans");
//		ComponentBeanTest cbt = context.getBean(ComponentBeanTest.class);
//		cbt.setId(100);
//		cbt.setName("JAVA");
//		System.out.println(cbt);
//		context.close();
	}
}
