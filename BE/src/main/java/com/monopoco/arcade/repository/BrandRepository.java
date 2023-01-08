package com.monopoco.arcade.repository;

import com.monopoco.arcade.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByBrandName(String brandName);

}
