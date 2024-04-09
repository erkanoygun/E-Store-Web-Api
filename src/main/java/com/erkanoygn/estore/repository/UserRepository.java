package com.erkanoygn.estore.repository;

import com.erkanoygn.estore.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}