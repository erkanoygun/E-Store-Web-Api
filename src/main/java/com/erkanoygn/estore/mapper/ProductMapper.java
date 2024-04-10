package com.erkanoygn.estore.mapper;

import com.erkanoygn.estore.dto.ProductDto;
import com.erkanoygn.estore.entitiy.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStock(),
                product.getPrice(),
                product.getProductType()
        );
    }

    public static Product mapToProduct(ProductDto productDto){

        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setProductType(productDto.getProductType());
        product.setStock(product.getStock());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
