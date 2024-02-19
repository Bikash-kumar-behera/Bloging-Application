package com.pns.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.pns.spring.model.Product;
import com.pns.spring.model.ResponseDto;
import com.pns.spring.model.Review;
import com.pns.spring.repo.ReviewRepository;
import com.pns.spring.service.ReviewService;

public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public ResponseDto<Review> getReviewFromProduct(Product product) {
//		ResponseDto<List<Review>> response;
//		if(reviews.size()!=0)
//			response = new ResponseDto<>(HttpStatus.OK, reviews.size()+" reviews found.", reviews);
//		else
//			response = new ResponseDto<>(HttpStatus.NOT_FOUND, "No reviews found.", null);
		return null;
	}

	@Override
	public ResponseDto<List<Review>> getAllReviews() {
		List<Review> reviews = reviewRepository.findAll();
		ResponseDto<List<Review>> response;
		if(reviews.size()!=0)
			response = new ResponseDto<>(HttpStatus.OK, reviews.size()+" reviews found.", reviews);
		else
			response = new ResponseDto<>(HttpStatus.NOT_FOUND, "No reviews found.", null);
		return response;
	}
	
}
