package com.monopoco.arcade.entity;


import com.monopoco.arcade.converter.YearAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "listed_price", nullable = false, columnDefinition = "Decimal(10,2)")
    private Double listedPrice;

    @Column(name = "model_year", columnDefinition = "smallint")
    @Convert(converter = YearAttributeConverter.class)
    private Year modelYear;

    @Lob
    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
