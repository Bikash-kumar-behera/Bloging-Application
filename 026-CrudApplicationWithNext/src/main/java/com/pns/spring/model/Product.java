package com.pns.spring.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product{
	@Id
	private String id;
	private String name;
	private int price;
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Review> reviews;
}
