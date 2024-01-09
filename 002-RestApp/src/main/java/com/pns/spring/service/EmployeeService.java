package com.pns.spring.service;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pns.spring.bean.EmployeeDetailsBean;
import com.pns.spring.bean.RequestDataBean;
import com.pns.spring.exception.ExtraArgumentsException;
import com.pns.spring.exception.InvalidDataArgumentsException;

@Service
public class EmployeeService {
	public ResponseEntity<EmployeeDetailsBean> getEmployeeDetails(RequestDataBean body) {
		if (body == null)
			throw new InvalidDataArgumentsException("Blank arguments");
		
		String data = body.getData();
		if (data == null)
			throw new InvalidDataArgumentsException("Provide some value for the field: data");
		Map<String, Object> extras = body.getAdditionalFields();
		if(extras.size()!=0) {
			StringBuffer errorMessage = new StringBuffer();
			extras.keySet().parallelStream().forEach(s->errorMessage.append(" "+s));
			throw new ExtraArgumentsException("Unwanted Fields Found:"+errorMessage);
		}

		String details[] = data.split(",");
		if (details.length != 4)
			throw new InvalidDataArgumentsException("Invalid Number of Argument for Data");

		details = validateData(details);
		return new ResponseEntity<EmployeeDetailsBean>(
				new EmployeeDetailsBean(details[0], details[1], details[2], details[3]), HttpStatus.OK);
	}

	private String[] validateData(String details[]) {
		for (int i = 0; i < details.length; i++) {
			if (i == 1)
				continue;
			details[i] = details[i].replaceAll("\\s", "");
		}
		return details;
	}
}
