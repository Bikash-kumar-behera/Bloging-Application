package com.pns.spring;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pns.spring.model.Vet;
import com.pns.spring.repo.VetRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CassandraApplication {

	@Autowired
	VetRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
	}
	
	@PostConstruct
	void createVet() {
		Set<String> set = new HashSet<>();
		set.add("Hacker");
		set.add("Jod");
		set.add("Pro");
		repo.save(new Vet(UUID.randomUUID(),"John","Cena",null));
		repo.save(new Vet(UUID.randomUUID(),"Jane","Smith",set));
	}
	
}
