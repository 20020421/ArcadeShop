package com.monopoco.arcade.requestbody;

import com.monopoco.arcade.entity.Brand;
import com.monopoco.arcade.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private Long id;

    private String productName;

    private Double listedPrice;

    private Year modelYear;

    private String description;

    private String image;

    private String categoryName;

    private String brandName;
}
