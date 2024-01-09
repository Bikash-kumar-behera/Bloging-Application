package com.pns.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pns.spring.model.UserDTO;
import com.pns.spring.repo.UserDAO;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringJWTApplication {

	@Autowired
	private UserDAO userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJWTApplication.class, args);
	}
	
	@PostConstruct
	public void initUsers() {
		userRepository.saveAll(
				List.of(new UserDTO(101,"Harish","101"),
				new UserDTO(102,"Ramesh","102"),
				new UserDTO(103,"Mukesh","103"),
				new UserDTO(104,"Dharmesh","104")));
	}
}
