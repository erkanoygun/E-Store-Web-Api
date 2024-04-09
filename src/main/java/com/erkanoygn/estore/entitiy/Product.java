package com.erkanoygn.estore.entitiy;

import com.erkanoygn.estore.enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="product_name", length=100, nullable=false)
    private String name;

    @ManyToMany(mappedBy = "products")
    private List<User> users;

    @Column(name="product_description", length=250, nullable=true)
    private String description;

    @Column(name="product_stock", nullable=false)
    private int stock;

    @Column(name="product_price", nullable=false)
    private float price;

    @Column(name="product_type", nullable=false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;
}










