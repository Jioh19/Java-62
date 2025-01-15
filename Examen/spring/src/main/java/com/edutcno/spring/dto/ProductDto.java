package com.edutcno.spring.dto;

import lombok.Data;

@Data
public class ProductDto {
	
	private String storeName;
	private Integer productId;
	private String productName;
	private Integer quantity;
}
