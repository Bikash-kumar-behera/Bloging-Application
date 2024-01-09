package com.pns.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pns.spring.bean.StudentDetailsBean;

@Component
public class StudentController {
	private static List<StudentDetailsBean> studentsList;
	public StudentController() {
		if(studentsList==null)
			studentsList=new ArrayList<>();
		if(studentsList.size()==0)
			createStudents();
	}
	private void createStudents() {
		studentsList.add(new StudentDetailsBean(2206151001L, "Anupam"));
		studentsList.add(new StudentDetailsBean(2206151002L, "Iswar"));
		studentsList.add(new StudentDetailsBean(2206151003L, "Sambit"));
		studentsList.add(new StudentDetailsBean(2206151004L, "Sonali"));
		studentsList.add(new StudentDetailsBean(2206151005L, "Priyabrata"));
	}
	public List<StudentDetailsBean> getStudentsList(){
		return studentsList;
	}
	public StudentDetailsBean getStudentById(long std_id) {
		List<StudentDetailsBean> sl = studentsList.stream().filter(e->(e.getStudent_id()==std_id)).toList();
		StudentDetailsBean sdb = sl.size()==1?sl.get(0):null;
		return sdb;
	}
}
