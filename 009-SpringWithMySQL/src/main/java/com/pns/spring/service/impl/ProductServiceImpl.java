package com.pns.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.spring.exception.InvalidCredentialsException;
import com.pns.spring.model.ProductDTO;
import com.pns.spring.repository.ProductRepository;
import com.pns.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static Integer ID = 1;
	
	@Autowired
	private ProductRepository repository;

	@Override
	public ProductDTO saveProduct(ProductDTO product) {
		if (!repository.existsByNameAndImgUrlAndPrice(product.getName(), product.getImgUrl(), product.getPrice())) {
			validateProduct(product);
			product.setId(ID++);
			product = repository.save(product);
		}
		return product;
	}

	private void validateProduct(ProductDTO product) {
		product.setName(product.getName().trim());
		product.setImgUrl(product.getImgUrl().trim());
	}

	@Override
	public List<ProductDTO> saveAllProducts(List<ProductDTO> products) {
		List<ProductDTO> newProducts = products.stream()
		.filter(product-> !repository.existsByNameAndImgUrlAndPrice(product.getName(), product.getImgUrl(), product.getPrice()))
		.toList();
		newProducts.forEach(product->product.setId(ID++));
		newProducts = repository.saveAll(newProducts);
		return newProducts;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public ProductDTO getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public boolean updateProduct(int id, ProductDTO product) {
		ProductDTO existingProduct = repository.findById(id).orElse(null);
		if (existingProduct != null && product != null) {
			product.setId(id);
			repository.save(product);
			return true;
		}
		return false;
	}

	@Override
	public int deleteProduct(int id, Map<String, String> headers) {
		String userName = headers.get("user-name");
		String userPass = headers.get("user-pass");

		if (userName == null || userPass == null)
			throw new InvalidCredentialsException("Admin Credentials Not Found");
		if (!userName.contentEquals("admin") || !userPass.contentEquals("realtiger"))
			throw new InvalidCredentialsException("Wrong Credentials");
		ProductDTO product = repository.findById(id).orElse(null);
		if (product != null) {
			repository.delete(product);
			return 0;
		}
		return -1;
	}

}
