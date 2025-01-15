package com.edutcno.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutcno.spring.dto.ProductDTO;
import com.edutcno.spring.model.Brand;
import com.edutcno.spring.model.Category;
import com.edutcno.spring.model.Product;
import com.edutcno.spring.model.Stock;
import com.edutcno.spring.model.Store;
import com.edutcno.spring.repository.BrandRepository;
import com.edutcno.spring.repository.CategoryRepository;
import com.edutcno.spring.repository.ProductRepository;
import com.edutcno.spring.repository.StockRepository;
import com.edutcno.spring.repository.StoreRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private BrandRepository brandRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private StockRepository stockRepository;
    
    public List<Store> getAllStores() {
        return storeRepository.findAllByOrderByStoreNameAsc();
    }
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAllByOrderByCategoryNameAsc();
    }
    
    public List<Brand> getAllBrands() {
        return brandRepository.findAllByOrderByBrandNameAsc();
    }
    
    public List<ProductDTO> getFilteredProducts(Integer storeId, Integer categoryId, Integer brandId) {
        List<Product> products = productRepository.findProductsWithFilters(storeId, categoryId, brandId);
        List<ProductDTO> productDTOs = new ArrayList<>();
        
        for (Product product : products) {
            ProductDTO dto = new ProductDTO();
            dto.setProductId(product.getProductId());
            dto.setProductName(product.getProductName());
            
            if (storeId != null) {
                Stock stock = stockRepository.findByStore_StoreIdAndProduct_ProductId(storeId, product.getProductId());
                Store store = storeRepository.findById(storeId).orElse(null);
                
                if (store != null) {
                    dto.setStoreName(store.getStoreName());
                }
                
                dto.setStock(stock != null ? stock.getQuantity() : 0);
            }
            
            productDTOs.add(dto);
        }
        
        return productDTOs;
    }
}