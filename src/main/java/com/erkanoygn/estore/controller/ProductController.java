package com.erkanoygn.estore.controller;

import com.erkanoygn.estore.dto.ProductDto;
import com.erkanoygn.estore.dto.UserDto;
import com.erkanoygn.estore.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {

    private ProductServices productServices;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){

        ProductDto savedProduct = productServices.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productServices.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productServices.deleteProductById(productId);
        return ResponseEntity.ok("User deleted successful");
    }


}
