package com.edutcno.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edutcno.spring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p " +
           "LEFT JOIN Stock s ON s.product = p " +
           "WHERE (:storeId IS NULL OR s.store.storeId = :storeId) " +
           "AND (:categoryId IS NULL OR p.category.categoryId = :categoryId) " +
           "AND (:brandId IS NULL OR p.brand.brandId = :brandId)")
    List<Product> findProductsWithFilters(
        @Param("storeId") Integer storeId,
        @Param("categoryId") Integer categoryId,
        @Param("brandId") Integer brandId
    );
}