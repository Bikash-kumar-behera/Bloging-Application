package com.pns.spring.service;

import java.util.List;

import com.pns.spring.model.Product;
import com.pns.spring.model.ResponseDto;
import com.pns.spring.model.Review;

public interface ReviewService {
	ResponseDto<Review> getReviewFromProduct(Product product);
	ResponseDto<List<Review>> getAllReviews();
}
