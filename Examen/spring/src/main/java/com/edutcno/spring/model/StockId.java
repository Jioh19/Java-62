package com.edutcno.spring.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "store_id")
    private Long storeId;
}