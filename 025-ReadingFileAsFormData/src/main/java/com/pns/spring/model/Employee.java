package com.pns.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "employee_details_form_data")
public class Employee {
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String gender;
}
