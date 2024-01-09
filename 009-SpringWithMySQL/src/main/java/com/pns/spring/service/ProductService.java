package com.pns.spring.service;

import java.util.List;
import java.util.Map;

import com.pns.spring.model.ProductDTO;

public interface ProductService {
	ProductDTO saveProduct(ProductDTO product);

	List<ProductDTO> saveAllProducts(List<ProductDTO> products);

	List<ProductDTO> getAllProducts();

	ProductDTO getProductById(int id);

	boolean updateProduct(int id, ProductDTO product);

	int deleteProduct(int id, Map<String,String> headers);
}
