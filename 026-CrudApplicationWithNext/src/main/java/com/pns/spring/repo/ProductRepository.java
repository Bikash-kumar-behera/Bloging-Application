package com.pns.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
