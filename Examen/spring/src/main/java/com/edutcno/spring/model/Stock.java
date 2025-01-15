package com.edutcno.spring.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "stocks")
@Data
public class Stock {
    @EmbeddedId
    private StockId id;
    
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
    
    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private Store store;
    
    private Integer quantity;
}