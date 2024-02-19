package com.pns.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.spring.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
