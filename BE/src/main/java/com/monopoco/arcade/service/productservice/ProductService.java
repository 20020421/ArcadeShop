package com.monopoco.arcade.service.productservice;

import com.monopoco.arcade.entity.Brand;
import com.monopoco.arcade.entity.Category;
import com.monopoco.arcade.entity.Product;

import java.util.List;

public interface ProductService {

    Brand addNewBrand(Brand brand);

    Category addNewCategory(Category category);

    Product addNewProduct(Product product);

    List<Product> getAllProduct();

    Product getProductByName(String productName);

    Product getProductById(Long id);

    List<Product> getProductsByBrand(String brandName);

    List<Product> getProductsByCategory(String categoryName);

    void addCategoryToProduct(String productName, String categoryName);

    void addBrandToProduct(String productName, String brandName);






}
