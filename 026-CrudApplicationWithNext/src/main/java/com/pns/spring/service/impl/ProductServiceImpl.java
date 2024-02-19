package com.pns.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.pns.spring.exception.MyCustomException;
import com.pns.spring.model.Product;
import com.pns.spring.model.ResponseDto;
import com.pns.spring.repo.ProductRepository;
import com.pns.spring.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ResponseDto<List<Product>> getAllProducts() {
		List<Product> products = productRepository.findAll();
		ResponseDto<List<Product>> response;
		if(products.size()!=0)
			response = new ResponseDto<>(HttpStatus.OK, products.size()+" products found.", products);
		else
			response = new ResponseDto<>(HttpStatus.NOT_FOUND, "No products found.", null);
		return response;
	}

	@Override
	public ResponseDto<Product> getProductById(String productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isEmpty())
			throw new MyCustomException("No products found", HttpStatus.NOT_FOUND);
		Product product = optional.get();
		ResponseDto<Product> response = new ResponseDto<>(HttpStatus.OK, "Product data fetched successfully", product);
		return response;
	}

}
