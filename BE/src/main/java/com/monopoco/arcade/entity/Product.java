package com.monopoco.arcade.entity;


import com.monopoco.arcade.converter.YearAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false, columnDefinition = "Decimal(10,2)")
    private Double price;

    @Column(name = "ribbon")
    private String ribbon;

    @Column(name = "sku")
    private String SKU;

    @Column(name = "visible")
    private boolean visible = true;

    @ManyToOne
    @JoinColumn(name = "discount_mode_id")
    private DiscountMode discountMode;

    @Column(name = "discount_value", nullable = false, columnDefinition = "Decimal(5,1)")
    private Double discountValue;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "additionalInfoTitle1")
    private AdditionalInfoTitle additionalInfoTitle1;

    @ManyToOne
    @JoinColumn(name = "additionalInfoTitle2")
    private AdditionalInfoTitle additionalInfoTitle2;

    @ManyToOne
    @JoinColumn(name = "additionalInfoTitle3")
    private AdditionalInfoTitle additionalInfoTitle3;

    @Lob
    @Column(name = "additionalInfoDescription1")
    private String additionalInfoDescription1;

    @Lob
    @Column(name = "additionalInfoDescription2")
    private String additionalInfoDescription2;

    @Lob
    @Column(name = "additionalInfoDescription3")
    private String additionalInfoDescription3;

    @OneToMany(mappedBy = "product")
    private Set<Image> images;

    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;








}
