package com.edutcno.spring.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="products")
public class Product {

	@Id
	private Integer productId;
	private String productName;
	
	@ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
	
	private Integer modelYear;
	private Double listPrice;
	
	@OneToMany(mappedBy = "product")
	private List<Stock> stocks;
}
