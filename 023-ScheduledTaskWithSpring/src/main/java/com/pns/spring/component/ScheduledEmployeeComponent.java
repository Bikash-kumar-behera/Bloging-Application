package com.pns.spring.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pns.spring.entity.Employee;
import com.pns.spring.service.ApacheCSVService;
import com.pns.spring.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduledEmployeeComponent {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ApacheCSVService apacheCSVService;
		
	@Scheduled(cron = "45 52 10 * * *")
	public void scheduledFetchDataFromDatabase() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Scheduled task running at "+sdf.format(new Date())+" everyday...");
		
		log.trace("TRACE AT COMPONENT");
		log.warn("WARN AT COMPONENT");
		log.info("INFO AT COMPONENT");
		
		List<Employee> employees = employeeService.fetchAllEmployeeDataFromDatabase();
		String headers[] = new String[] { "id", "first_name", "last_name", "email", "gender", "profession" };
		System.out.println("Wrote data to path: "+ apacheCSVService.writeEmployeesToCsv(headers, employees));	
	}
}
