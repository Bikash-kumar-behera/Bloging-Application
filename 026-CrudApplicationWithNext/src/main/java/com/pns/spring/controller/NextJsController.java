package com.pns.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.Product;
import com.pns.spring.model.ResponseDto;
import com.pns.spring.model.Review;
import com.pns.spring.service.ProductService;
import com.pns.spring.service.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NextJsController {

	@Autowired
	ProductService productService;

	@Autowired
	ReviewService reviewService;

	@GetMapping("product/get/{prodId}")
	public ResponseEntity<ResponseDto<Product>> getProductById(@PathVariable("prodId") String productId) {
		ResponseDto<Product> response = productService.getProductById(productId);
		return new ResponseEntity<>(response, response.getStatus());
	}

	@GetMapping("product/getAll")
	public ResponseEntity<ResponseDto<List<Product>>> getAllProductById() {
		ResponseDto<List<Product>> response = productService.getAllProducts();
		return new ResponseEntity<>(response, response.getStatus());
	}

	@GetMapping("review/getAll")
	public ResponseEntity<ResponseDto<List<Review>>> getAllReview() {
		ResponseDto<List<Review>> response = reviewService.getAllReviews();
		return new ResponseEntity<>(response, response.getStatus());
	}
}
