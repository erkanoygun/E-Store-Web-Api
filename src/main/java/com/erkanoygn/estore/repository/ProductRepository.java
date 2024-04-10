package com.erkanoygn.estore.repository;

import com.erkanoygn.estore.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
