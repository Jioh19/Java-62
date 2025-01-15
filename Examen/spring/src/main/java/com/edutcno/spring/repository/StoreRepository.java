package com.edutcno.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutcno.spring.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    List<Store> findAllByOrderByStoreNameAsc();
}