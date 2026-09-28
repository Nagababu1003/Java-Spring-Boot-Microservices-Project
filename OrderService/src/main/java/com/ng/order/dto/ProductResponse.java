package com.ng.order.dto;

import lombok.Data;

@Data
public class ProductResponse {

	private Long id;
	private String name;
	private Integer quantity;
	private Double price;
}
