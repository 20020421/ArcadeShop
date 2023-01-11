package com.monopoco.arcade.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "caregories")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    private String id;

    @Column(name = "category_name", unique = true)
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;


}
