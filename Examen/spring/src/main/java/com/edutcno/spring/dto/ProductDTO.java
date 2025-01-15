package com.edutcno.spring.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String storeName;
    private Integer productId;
    private String productName;
    private Integer stock;
}