package com.edutcno.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edutcno.spring.dto.ProductDto;
import com.edutcno.spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByStoreIdAndCategoryIdAndBrandId(
	        Integer storeId, Integer categoryId, Integer brandId);
	
//	@Query("select new com.edutcno.spring.dto(st.store_name, "
//			+ "p.product_id, p.product_name, s.quantity) "
//			+ "from products as p "
//			+ "inner join categories as c "
//			+ "on c.category_id = p.category_id "
//			+ "inner join brands as b "
//			+ "on b.brand_id = p.brand_id "
//			+ "inner join stocks as s "
//			+ "on s.product_id = p.product_id "
//			+ "inner join stores as st "
//			+ "on st.store_id = s.store_id ")
//	List<ProductDto> filtrarTodo();
}
