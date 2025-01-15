package com.edutcno.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutcno.spring.model.Stock;
import com.edutcno.spring.model.StockId;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {
    List<Stock> findByStore_StoreId(Integer storeId);
    Stock findByStore_StoreIdAndProduct_ProductId(Integer storeId, Integer productId);
}