package com.pns.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.model.CarDTO;
import com.pns.spring.model.ResponseDTO;
import com.pns.spring.service.PaginationService;

@RestController
@RequestMapping("cars")
public class PaginationController {
	
	@Autowired
	private PaginationService service;
		
	@GetMapping("getAll")
	public ResponseEntity<ResponseDTO<List<CarDTO>>> getAllCars() {
		List<CarDTO> carList = service.getCars();
		String message;
		HttpStatus status;
		Integer recordCount = null;
		if(carList!=null) {
			message = String.format("Found %d Cars", carList.size());
			status = HttpStatus.OK;
			recordCount = carList.size();
		} else {
			message = "No cars found";
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(new ResponseDTO<>(recordCount, message, carList), status);
	}
	
	@PostMapping("saveAll")
	public ResponseEntity<String> postMethodName(@RequestBody List<CarDTO> cars) {
		cars = service.saveCars(cars);
		String message;
		HttpStatus status;
		if(cars!=null) {
			message = String.format("Saved %d Cars", cars.size());
			status = HttpStatus.OK;
		} else {
			message = "Something went wrong";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(message, status);
	}
	
	@GetMapping("sort/{field}")
	public ResponseEntity<ResponseDTO<List<CarDTO>>> getWithSortByField(@PathVariable String field) {
		List<CarDTO> carList = service.findWithSortBy(field);
		String message;
		HttpStatus status;
		Integer recordCount = null;
		if(carList!=null) {
			message = String.format("Found %d Cars", carList.size());
			status = HttpStatus.OK;
			recordCount = carList.size();
		} else {
			message = "No cars found";
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(new ResponseDTO<>(recordCount, message, carList), status);
	}
	
	@GetMapping("page/{pageNumber}/{pageSize}")
	public ResponseEntity<ResponseDTO<List<CarDTO>>> getWithPagingation(@PathVariable int pageNumber, @PathVariable int pageSize) {
		List<CarDTO> carList = service.findWithPagination(pageNumber, pageSize);
		String message;
		HttpStatus status;
		Integer recordCount = null;
		if(carList!=null) {
			message = String.format("Found %d Cars", carList.size());
			status = HttpStatus.OK;
			recordCount = carList.size();
		} else {
			message = "No cars found";
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(new ResponseDTO<>(recordCount, message, carList), status);
	}
	
}
