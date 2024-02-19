package com.pns.spring.service;

import java.util.List;

import com.pns.spring.model.Product;
import com.pns.spring.model.ResponseDto;

public interface ProductService {
	ResponseDto<List<Product>> getAllProducts();
	ResponseDto<Product> getProductById(String productId);
}
