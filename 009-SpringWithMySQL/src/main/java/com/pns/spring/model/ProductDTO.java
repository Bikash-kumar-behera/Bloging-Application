package com.pns.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_table")

public class ProductDTO {
	
	@Id
	@JsonProperty("id")
	private Integer id;

	@NotNull(message = "name Field Must Be added")
	@JsonProperty("name")
	private String name;

	@NotNull(message = "price Field Must Be added")
	@JsonProperty("price")
	private Double price;

	@NotNull(message = "img_url Field Must Be added")
	@Column(name = "img_url")
	@JsonProperty("img_url")
	private String imgUrl;
}
