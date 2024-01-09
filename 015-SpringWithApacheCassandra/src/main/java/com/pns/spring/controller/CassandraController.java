package com.pns.spring.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.Vet;
import com.pns.spring.repo.VetRepository;

@RestController
public class CassandraController {
	@Autowired
	VetRepository repo;
	
	@GetMapping("get/{id}")
	public Vet getVet(@PathVariable("id") UUID id) {
		System.out.println("==="+id);
		return repo.findById(id).get();
	}
}
