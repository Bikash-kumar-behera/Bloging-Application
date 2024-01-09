package com.pns.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pns.spring.model.EligibleEmployeeBean;
import com.pns.spring.model.RequestBean;
import com.pns.spring.model.ResponseBean;

@Service
public class GiftService {

	@Autowired
	ResponseBean response;

	public ResponseEntity<ResponseBean> checkEligibles(RequestBean requestData) {
		final List<EligibleEmployeeBean> eligibleEmployeeList = new ArrayList<>();
		
		requestData.getEmployeeList().parallelStream()
				.filter(emp -> !isEligibleEmployee(emp.getCode(),emp.getName()))
				.toList()
				.forEach(e->eligibleEmployeeList.add(new EligibleEmployeeBean(e.getName(), "Not-applicable for gift")));
		
		requestData.getEmployeeList().parallelStream()
		.filter(emp -> isEligibleEmployee(emp.getCode(),emp.getName()))
		.toList()
		.forEach(e->eligibleEmployeeList.add(new EligibleEmployeeBean(e.getName(), "applicable for gift")));
		
		response.setSelectedEmployeeList(eligibleEmployeeList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	private boolean isEligibleEmployee(int code, String name) {
		return isOdd(code) && isPrime(code) && checkFirstCharacter(name);
	}

	private boolean isOdd(int number) {
		return number % 2 != 0;
	}
	
	private boolean isPrime(int number) {
		if (number <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) 
			if (number % i == 0) return false;
		return true;
	}

	private boolean checkFirstCharacter(String name) {
		return name.startsWith("p") || name.startsWith("P");
	}
}
