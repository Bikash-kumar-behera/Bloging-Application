package com.pns.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pns.spring.bean.EmployeeDetailsBean;
import com.pns.spring.bean.RequestDataBean;
import com.pns.spring.bean.StudentDetailsBean;
import com.pns.spring.controller.StudentController;
import com.pns.spring.service.EmployeeService;

@RestController
@RequestMapping("/rest/api")
public class RestAppController {
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	StudentController studentController;

	@GetMapping("/welcome")
	private ResponseEntity<String> getWelcomeMessage() {
//		return new ResponseEntity<String>("WELCOME MESSAGE", HttpStatus.OK);
		return ResponseEntity.ok("WELCOME TO SPRING");
	}

	@PostMapping(value = "/post", consumes = { "application/json" }, produces = { "application/json" })
	private ResponseEntity<EmployeeDetailsBean> getUserDetails(@RequestBody RequestDataBean body) {
		return employeeService.getEmployeeDetails(body);
	}

	/***
	 * 
	 * My own implementations
	 * 
	 */

	@GetMapping("/student/all")
	private ResponseEntity<List<StudentDetailsBean>> getStudentList() {
		return ResponseEntity.ok(studentController.getStudentsList());
	}

	@GetMapping("/student/{id}")
	private ResponseEntity<Object> getStudentById(@PathVariable long id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"com.pns.spring.controller");
		StudentController sc = context.getBean(StudentController.class);
		context.close();
		StudentDetailsBean sdb = sc.getStudentById(id);
		if (sdb == null)
			return ResponseEntity.status(404).body("No details found");
		return ResponseEntity.ok(sdb);
	}
}
