package com.edutcno.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
	@Id
	private Integer brandId;
	private String brandName;
}
