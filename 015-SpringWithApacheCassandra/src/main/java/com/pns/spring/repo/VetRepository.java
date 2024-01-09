package com.pns.spring.repo;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.pns.spring.model.Vet;

public interface VetRepository extends CassandraRepository<Vet, UUID> {  
  Vet findByFirstName(String username);
}