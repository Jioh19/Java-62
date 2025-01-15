package com.edutcno.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutcno.spring.dto.ProductDTO;
import com.edutcno.spring.service.ProductService;

@RestController
@RequestMapping("/api/productos")
public class ProductControllerRest {

    @Autowired
    private ProductService productService;


    // Endpoint para obtener productos por tienda
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<ProductDTO>> getProductsByStore(@PathVariable Integer storeId) {
        List<ProductDTO> products = productService.getFilteredProducts(storeId, null, null);
        return ResponseEntity.ok(products);
    }

    
    @GetMapping("/{storeId}/{categoryId}/{brandId}")
    public ResponseEntity<List<ProductDTO>> getFilteredProducts(
            @PathVariable Integer storeId,
            @PathVariable Integer categoryId,
            @PathVariable Integer brandId) {
        try {
            List<ProductDTO> productos = productService.getFilteredProducts(storeId, categoryId, brandId);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
