package com.monopoco.arcade.api;


import com.monopoco.arcade.entity.Brand;
import com.monopoco.arcade.entity.Category;
import com.monopoco.arcade.entity.Product;
import com.monopoco.arcade.requestbody.ProductRequest;
import com.monopoco.arcade.service.productservice.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.Location;
import java.net.URI;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {

    @Autowired private ProductService productService;


    @PostMapping("/products/categories")
    public ResponseEntity<?> addNewCategory(@RequestBody Category category) {
        Category savedCategory = productService.addNewCategory(category);
        URI location = URI.create(String.format("/products/categories/%s", category.getCategoryName()));
        if (savedCategory != null) {
            return ResponseEntity.created(location).build();
        }

        return ResponseEntity.badRequest().build();

    }

    @PostMapping("/products/brands")
    public ResponseEntity<?> addNewBrand(@RequestBody Brand brand) {
        Brand savedBrand = productService.addNewBrand(brand);
        URI location = URI.create(String.format("/products/brands/%s", brand.getBrandName()));
        if (savedBrand != null) {
            return ResponseEntity.created(location).body(brand);
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        if (products.size() > 0) {
            return ResponseEntity.ok(products);
        }

        return ResponseEntity.noContent().build();

    }



    @PostMapping("/products")
    public ResponseEntity<?> addNewProduct(@RequestBody ProductRequest productRequest) {

        String brandName = productRequest.getBrandName();

        String categoryName = productRequest.getCategoryName();


        Product product = new Product(productRequest.getId(), productRequest.getProductName(), productRequest.getListedPrice(),
                productRequest.getModelYear(), productRequest.getDescription(), productRequest.getImage(), null, null);



        log.info(product.toString());
        Product savedProduct = productService.addNewProduct(product);


        URI location = URI.create(String.format("/products/%s", product.getProductName()));

        log.info(savedProduct.toString());

        if (savedProduct != null) {
            log.info("Add {} successfully", savedProduct.getProductName());
            productService.addBrandToProduct(savedProduct.getProductName(), brandName);
            productService.addCategoryToProduct(savedProduct.getProductName(), categoryName);
            return ResponseEntity.created(location).body(savedProduct);
        }

        return ResponseEntity.badRequest().build();
    }



}
