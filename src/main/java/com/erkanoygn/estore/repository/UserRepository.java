package com.erkanoygn.estore.repository;

import com.erkanoygn.estore.entitiy.Product;
import com.erkanoygn.estore.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN u.products p WHERE p = :product")
    List<User> findByProduct(@Param("product") Product product);
}