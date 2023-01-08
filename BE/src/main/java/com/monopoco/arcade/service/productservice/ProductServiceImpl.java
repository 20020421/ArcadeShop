package com.monopoco.arcade.service.productservice;

import com.monopoco.arcade.entity.Brand;
import com.monopoco.arcade.entity.Category;
import com.monopoco.arcade.entity.Product;
import com.monopoco.arcade.repository.BrandRepository;
import com.monopoco.arcade.repository.CategoryRepository;
import com.monopoco.arcade.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Brand addNewBrand(Brand brand) {

        boolean isExist = brandRepository.findByBrandName(brand.getBrandName()) != null;
        if (!isExist) {
            log.info("Adding new brand : {}" , brand.getBrandName());
            return brandRepository.save(brand);
        } else {
            log.warn("The brand has exist...");
        }
        return null;
    }

    @Override
    public Category addNewCategory(Category category) {
        boolean isExist = categoryRepository.findByCategoryName(category.getCategoryName()) != null;
        if (!isExist) {
            log.info("Adding new category : {}", category.getCategoryName());
            return categoryRepository.save(category);
        } else {
            log.warn("The category {} has exits");
        }
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {

        Product savedProduct = productRepository.save(product);

        if (savedProduct == null) {
            log.warn("Product {} has exist", product.getProductName());
        } else {
            log.info("Adding new product: {}", product.getProductName());
            return savedProduct;
        }

        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).get();

        return product;
    }

    @Override
    public List<Product> getProductsByBrand(String brandName) {
        return productRepository.findAllByBrand_BrandName(brandName);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findAllByCategory_CategoryName(categoryName);
    }

    @Override
    public void addCategoryToProduct(String productName, String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName);
        if (category == null) {
            category = categoryRepository.save(new Category(null, categoryName));
        }

        Product product = productRepository.findByProductName(productName);

        product.setCategory(category);
    }

    @Override
    public void addBrandToProduct(String productName, String brandName) {
        Brand brand = brandRepository.findByBrandName(brandName);

        if (brand == null) {
            brand = brandRepository.save(new Brand(null, brandName));
        }

        Product product = productRepository.findByProductName(productName);

        product.setBrand(brand);
    }


}
