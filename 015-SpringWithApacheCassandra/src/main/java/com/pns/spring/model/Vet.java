package com.pns.spring.model;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(value = "vet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vet {
  
  @PrimaryKey
  private UUID id;

  private String firstName;
  
  private String lastName;
  
  private Set<String> specialties;
  
}