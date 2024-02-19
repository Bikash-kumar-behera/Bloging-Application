package com.pns.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_details")
public class Employee {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String profession;
	
	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%s", id,firstName,lastName,email,gender,profession);
	}
}
