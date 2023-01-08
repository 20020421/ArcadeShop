package com.monopoco.arcade.repository;

import com.monopoco.arcade.entity.Brand;
import com.monopoco.arcade.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductName(String productName);

    List<Product> findAllByBrand_BrandName(String brandName);

    List<Product> findAllByCategory_CategoryName(String categoryName);

}
