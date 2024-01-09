package com.pns.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pns.spring.model.CarDTO;
import com.pns.spring.repository.CarDAO;

@Service
public class PaginationService {
	@Autowired
	CarDAO carDAO;
	
	public List<CarDTO> saveCars(List<CarDTO> cars) {
		return carDAO.saveAll(cars);
	}
	
	public List<CarDTO> getCars() {
		return carDAO.findAll();
	}
	
	public List<CarDTO> findWithSortBy(String field){
		return carDAO.findAll(Sort.by(Direction.ASC, field));
	}
	
	public List<CarDTO> findWithPagination(int pageNumber,int pageSize){
		return carDAO.findAll(PageRequest.of(pageNumber, pageSize)).toList();
	}
}
