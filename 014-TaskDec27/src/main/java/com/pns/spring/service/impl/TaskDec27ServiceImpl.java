package com.pns.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pns.spring.exception.MyCustomException;
import com.pns.spring.model.CustomerDTO;
import com.pns.spring.model.GetCustomerRequestDTO;
import com.pns.spring.model.RequestDTO;
import com.pns.spring.repo.CustomerDAO;
import com.pns.spring.service.TaskDec27Service;

@SuppressWarnings("unchecked")
@Service
public class TaskDec27ServiceImpl implements TaskDec27Service {
	
	@Autowired
	CustomerDAO customerRepository;

	private static int ID = 1;

	@Override
	public CustomerDTO saveCustomer(CustomerDTO customer) {
		return customerRepository.save(customer);
	}

	// to be used by controller
	public boolean save(RequestDTO requestDTO) {
		CustomerDTO customerDTO = new CustomerDTO();
		createCustomer(requestDTO, customerDTO);
		if (!customerRepository.existsByAgeAndPincodeAndAdditionalFieldAndCityAndName(customerDTO.getAge(),
				customerDTO.getPincode(), customerDTO.getAdditionalField(), customerDTO.getCity(),
				customerDTO.getName())) {
			customerDTO.setId(ID++);
			customerDTO = customerRepository.save(customerDTO);
//			customerDTO = customerRepository.storeCust(customerDTO.getAge(),customerDTO.getId(),
//					customerDTO.getPincode(),customerDTO.getCity(),customerDTO.getName(),
//					customerDTO.getAdditionalField());
		} else
			throw new MyCustomException("Customer details already Available");
		return customerDTO != null;
	}

	// validate the request and create the customer object to be stored by the user
	private void createCustomer(RequestDTO requestDTO, CustomerDTO customerDTO) {

		// to store all the errors and throw them together
		StringBuffer errorMessage = new StringBuffer("error(s): ");

		requestDTO.setLocation(requestDTO.getLocation().trim());
		requestDTO.getLocation().replaceAll(" ", "");

		// checking number of fields in location
		String location[] = requestDTO.getLocation().split(",");
		if (location.length != 3)
			errorMessage.append("3 fields are needed for location");

		if (errorMessage.length() > 10) {
			errorMessage.setLength(errorMessage.length() - 2);
			throw new MyCustomException(errorMessage.toString());
		}

		JSONObject extrasJson = requestDTO.getAdditionalfield();

		
		extrasJson.put("051", extrasJson.get("051").toString().trim().replaceAll(" ", ""));
		extrasJson.put("01", extrasJson.get("01").toString().trim().replaceAll(" ", ""));
		extrasJson.put("099", extrasJson.get("099").toString().trim().replaceAll(" ", ""));
		extrasJson.put("area",location[0].trim());

		// storing the data to customerDTO if no exception raises
		customerDTO.setAge(requestDTO.getAge());
		customerDTO.setPincode(Long.parseLong(location[1]));
		customerDTO.setCity(location[2].trim());

		// creating additional fields String
		customerDTO.setName(requestDTO.getName().replaceAll(" ", ""));
		customerDTO.setAdditionalField(requestDTO.getAdditionalfield());
		
		System.out.println("TaskDec27ServiceImpl.createCustomer():"+customerDTO);
	}

	@Override
	public CustomerDTO getCustomer(GetCustomerRequestDTO requestDTO) {
		
		//trimming all fields
		requestDTO.setAdditionalField(requestDTO.getAdditionalField().trim().replaceAll(" ", ""));
		requestDTO.setLocation(requestDTO.getLocation().trim().replaceAll(" ", ""));
		requestDTO.setCustomername(requestDTO.getCustomername().trim().replaceAll(" ", ""));
		
//		List<CustomerDTO> customers = customerRepository.findByNameAndCity(requestDTO.getCustomername(),
//				requestDTO.getLocation());
		
		List<CustomerDTO> customers = customerRepository.findByNameAndCityAndAdditional(requestDTO.getCustomername(), requestDTO.getLocation(), requestDTO.getAdditionalField());
		if (customers.size() <= 0)
			return null;
		
		// atleast one customer is found
		// check for the match with additional details
		Optional<CustomerDTO> customerDTO = customers.stream()
				.filter(customer -> customer.getAdditionalField()
				.get("051").toString().contentEquals(requestDTO.getAdditionalField())).findFirst();
		return customerDTO.isPresent() ? customerDTO.get() : null;
	}
}
