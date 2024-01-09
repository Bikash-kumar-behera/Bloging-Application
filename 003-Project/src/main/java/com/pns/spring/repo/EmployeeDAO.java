package com.pns.spring.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pns.spring.model.EmployeeDTO;

@Repository
public class EmployeeDAO extends ObjectDAO<EmployeeDTO> {

	List<EmployeeDTO> employeeList;
	public EmployeeDAO() {
		if(employeeList==null)
			employeeList = new ArrayList<EmployeeDTO>();
	}
	@Override
	public boolean save(EmployeeDTO employee) {
		if(employeeList.parallelStream().filter(e->e.getId()==employee.getId()).toList().size()!=0)
			return false;
		return employeeList.add(employee);
	}

	@Override
	public EmployeeDTO search(int id) {
		List<EmployeeDTO> list = employeeList.parallelStream().filter(e->e.getId()==id).toList();
		return list.size()!=0?list.get(0):null;
	}

	@Override
	public boolean delete(int id) {
		List<EmployeeDTO> list = employeeList.parallelStream().filter(e->e.getId()==id).toList();
		if(list.size()==0)
			return false;
		EmployeeDTO employee = list.get(0);
		return employeeList.remove(employee);
	}
	@Override
	public List<EmployeeDTO> all() {
		return employeeList;
	}
}
