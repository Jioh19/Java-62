package com.edutcno.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutcno.spring.service.ProductService;



@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/")
    public String showProducts(Model model) {
        model.addAttribute("stores", productService.getAllStores());
        model.addAttribute("categories", productService.getAllCategories());
        model.addAttribute("brands", productService.getAllBrands());
        return "products";
    }
    
    @GetMapping("/filter")
    public String filterProducts(
            @RequestParam(required = false) Integer storeId,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer brandId,
            Model model) {
        
        model.addAttribute("stores", productService.getAllStores());
        model.addAttribute("categories", productService.getAllCategories());
        model.addAttribute("brands", productService.getAllBrands());
        model.addAttribute("products", 
            productService.getFilteredProducts(storeId, categoryId, brandId));
        
        // Mantener los valores seleccionados
        model.addAttribute("selectedStore", storeId);
        model.addAttribute("selectedCategory", categoryId);
        model.addAttribute("selectedBrand", brandId);
        
        return "products";
    }
}