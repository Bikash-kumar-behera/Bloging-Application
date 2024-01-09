package com.pns.spring.bean;

public class StudentDetailsBean {
	private long student_id;
	private String student_name;
	public long getStudent_id() {
		return student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public StudentDetailsBean(long student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
	}
}
