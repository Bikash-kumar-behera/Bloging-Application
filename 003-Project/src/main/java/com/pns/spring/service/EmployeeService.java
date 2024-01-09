package com.pns.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pns.spring.model.CustomResponseDTO;
import com.pns.spring.model.EmployeeDTO;
import com.pns.spring.repo.EmployeeDAO;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	public ResponseEntity<CustomResponseDTO<EmployeeDTO>> saveEmployee(EmployeeDTO employee) {
		boolean isSaved = employeeDAO.save(employee);
		String message = isSaved?"Data Added Successfully":"Data with same ID already Exists";
		CustomResponseDTO<EmployeeDTO> response = new CustomResponseDTO<>();
		response.setMessage(message);
		response.setT(employee);
		HttpStatus status = isSaved?HttpStatus.CREATED:HttpStatus.ALREADY_REPORTED;
		return new ResponseEntity<>(response, status);
	}
	public ResponseEntity<CustomResponseDTO<EmployeeDTO>> deleteEmployee(Integer id) {
		boolean isDeleted = employeeDAO.delete(id);
		String message = isDeleted?"Employee Deleted Successfully":"Employee does not exist";
		CustomResponseDTO<EmployeeDTO> response = new CustomResponseDTO<>();
		response.setMessage(message);
		HttpStatus status = isDeleted?HttpStatus.ACCEPTED:HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response, status);
	}
	public ResponseEntity<CustomResponseDTO<EmployeeDTO>> searchEmployee(Integer id) {
		EmployeeDTO employee = employeeDAO.search(id);
		String message = employee!=null?"Employee is Found":"Employee Not Found";
		CustomResponseDTO<EmployeeDTO> response = new CustomResponseDTO<>();
		response.setMessage(message);
		response.setT(employee);
		HttpStatus status = employee!=null?HttpStatus.OK:HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response, status);
	}
	public ResponseEntity<CustomResponseDTO<List<EmployeeDTO>>> getAll() {
		List<EmployeeDTO> allEmployeeList = employeeDAO.all();
		String message = allEmployeeList.size()==0?"No Employee Found":allEmployeeList.size()+" employees Found";
		CustomResponseDTO<List<EmployeeDTO>> response = new CustomResponseDTO<>();
		response.setMessage(message);
		response.setT(allEmployeeList);
		HttpStatus status = allEmployeeList.size()!=0?HttpStatus.OK:HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response, status);
	}
}
