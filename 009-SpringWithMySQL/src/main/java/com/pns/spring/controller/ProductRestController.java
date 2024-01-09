package com.pns.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.ProductDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.service.impl.ProductServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
@Validated
public class ProductRestController {
	@Autowired
	private ProductServiceImpl productService;

	@PostMapping("save")
	public ResponseEntity<ResponseDTO<ProductDTO>> saveProduct(@Valid @RequestBody ProductDTO product) {
		HttpStatus status;
		String message;
		product = productService.saveProduct(product);
		if (product == null) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			message = "Can not save product";
		} else if(product.getId()!=null) {
			status = HttpStatus.CREATED;
			message = "Product Saved Successfully with id=" + product.getId();
		}else {
			status = HttpStatus.ALREADY_REPORTED;
			message = "Product already exists";
		}
		return new ResponseEntity<>(new ResponseDTO<>(message, null), status);
	}

	@PostMapping("saveAll")
	public ResponseEntity<ResponseDTO<ProductDTO>> saveAllProducts(@RequestBody List<ProductDTO> products) {
		HttpStatus status;
		String message;
		List<ProductDTO> savedProducts = productService.saveAllProducts(products);
		if (savedProducts==null) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			message = "Can not save products";
		} else if(savedProducts.size()!=0){
			status = HttpStatus.CREATED;
			message = savedProducts.size()+" new products found and saved successfully";
		} else {
			status = HttpStatus.ALREADY_REPORTED;
			message = "No new product to be added";
		}
		return new ResponseEntity<>(new ResponseDTO<>(message, null), status);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ResponseDTO<ProductDTO>> updateProduct(@PathVariable int id,
			@RequestBody ProductDTO product) {
		HttpStatus status;
		String message;
		boolean result = productService.updateProduct(id, product);
		if (result) {
			status = HttpStatus.CREATED;
			message = "Product Updated Successfully";
		} else {
			status = HttpStatus.NOT_FOUND;
			message = "Product with provided ID not found";
		}
		return new ResponseEntity<>(new ResponseDTO<>(message, null), status);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<ResponseDTO<ProductDTO>> deleteProduct(@PathVariable int id,
			@RequestHeader Map<String,String> headers) {
		HttpStatus status;
		String message;
		int result = productService.deleteProduct(id, headers);
		if( result == -1){
			status = HttpStatus.NOT_FOUND;
			message = "Product with provided ID not found";
		} else {
			status = HttpStatus.NOT_FOUND;
			message = "Product Deleted Successfully";
		}
		return new ResponseEntity<>(new ResponseDTO<>(message, null), status);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<ResponseDTO<ProductDTO>> getProduct(@PathVariable int id) {
		HttpStatus status;
		String message;
		ProductDTO product = productService.getProductById(id);
		if (product != null) {
			status = HttpStatus.OK;
			message = "Product Fetched Successfully";
		} else {
			status = HttpStatus.NOT_FOUND;
			message = "Product with provided ID not found";
		}
		return new ResponseEntity<>(new ResponseDTO<>(message, product), status);
	}

	@GetMapping("getAll")
	public ResponseEntity<ResponseDTO<List<ProductDTO>>> getAllProducts() {
		HttpStatus status;
		String message;
		List<ProductDTO> allProducts = productService.getAllProducts();
		if (allProducts != null) {
			status = HttpStatus.OK;
			message = allProducts.size() + " products found";
		} else {
			status = HttpStatus.NOT_FOUND;
			message = "No Product found, add some";
		}
		return new ResponseEntity<>(new ResponseDTO<>(message, allProducts), status);
	}

}
