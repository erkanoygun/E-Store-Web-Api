package com.erkanoygn.estore.controller;

import com.erkanoygn.estore.dto.ProductDto;
import com.erkanoygn.estore.dto.UserDto;
import com.erkanoygn.estore.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {

    private ProductServices productServices;


}
