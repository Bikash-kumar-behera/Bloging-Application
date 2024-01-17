package com.pns.spring.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pns.spring.service.EmployeeService;

@Component
public class ScheduledEmployeeComponent {

	@Autowired
	EmployeeService employeeService;

	@Scheduled(cron = "20 34 14 * * *")
	public void scheduledFetchDataFromDatabase() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Scheduled task running at "+sdf.format(new Date())+" everyday..");
		employeeService.fetchDataFromDatabaseAndWriteToCsv();
		System.out.println("Completed the scheduled task...");
	}
}
