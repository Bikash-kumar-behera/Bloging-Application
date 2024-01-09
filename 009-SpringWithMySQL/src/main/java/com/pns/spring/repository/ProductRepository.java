package com.pns.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pns.spring.model.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Integer> {
	boolean existsByNameAndImgUrlAndPrice(String name, String imgUrl, Double price);
}
