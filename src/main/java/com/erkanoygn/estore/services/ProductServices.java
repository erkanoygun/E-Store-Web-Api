package com.erkanoygn.estore.services;

import com.erkanoygn.estore.dto.ProductDto;

import java.util.List;

public interface ProductServices {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();
    void deleteProductById(Long productId);
}
