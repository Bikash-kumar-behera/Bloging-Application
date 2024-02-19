package com.pns.spring.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pns.spring.model.Product;
import com.pns.spring.model.ResponseDto;
import com.pns.spring.model.Review;
import com.pns.spring.repo.ProductRepository;
import com.pns.spring.service.ProductService;
import com.pns.spring.service.ReviewService;

import jakarta.annotation.PostConstruct;

@Component
public class NextJsComponent {

	@Autowired
	ProductService productService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ProductRepository productRepository;
	
//	@PostConstruct
	void addData() {
		List<Review> review1 = List.of(
				new Review(0, "Good"),
				new Review(0, "Nice"),
				new Review(0, "Very good"),
				new Review(0, "Noice"),
				new Review(0, "Really good"));
		List<Review> review2 = List.of(
				new Review(0, "Good"),
				new Review(0, "Nice"),
				new Review(0, "Very good"));
		List<Review> review3 = List.of(
				new Review(0, "Good"),
				new Review(0, "Nice"),
				new Review(0, "Very good"),
				new Review(0, "Noice"),
				new Review(0, "Really good"));
		List<Review> review4 = List.of(
				new Review(0, "Good"),
				new Review(0, "Nice"),
				new Review(0, "Very good"),
				new Review(0, "Noice"),
				new Review(0, "Really good"));
		List<Review> review5 = List.of(
				new Review(0, "Good"),
				new Review(0, "Nice"),
				new Review(0, "Very good"),
				new Review(0, "Noice"),
				new Review(0, "Really good"));
		
		List<Product> products = new ArrayList<>();
		products.add(new Product("P1", "Table", 650, review1));
		products.add(new Product("P2", "Chair", 310, review2));
		products.add(new Product("P3", "Bucket", 230, review3));
		products.add(new Product("P4", "Mug", 120, review4));
		products.add(new Product("P5", "Laptop", 63590, review5));
		
		productRepository.saveAll(products);
	}
	
	ResponseDto<List<Product>> getAllProducts(){
		return productService.getAllProducts();
	}
	
	ResponseDto<Product> getProductById(String productId) {
		return productService.getProductById(productId);
	}
	
	ResponseDto<List<Review>> getAllReviews() {
		return reviewService.getAllReviews();
	}
	
	ResponseDto<Review> getReviewsForProduct(Product product) {
		return reviewService.getReviewFromProduct(product);
	}
	
}
