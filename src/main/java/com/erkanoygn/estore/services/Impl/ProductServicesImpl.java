package com.erkanoygn.estore.services.Impl;

import com.erkanoygn.estore.dto.ProductDto;
import com.erkanoygn.estore.entitiy.Product;
import com.erkanoygn.estore.entitiy.User;
import com.erkanoygn.estore.exception.ResourceNotFoundException;
import com.erkanoygn.estore.mapper.ProductMapper;
import com.erkanoygn.estore.mapper.UserMapper;
import com.erkanoygn.estore.repository.ProductRepository;
import com.erkanoygn.estore.repository.UserRepository;
import com.erkanoygn.estore.services.ProductServices;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServicesImpl implements ProductServices {

    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));


        List<User> users = userRepository.findByProduct(product);
        for (User user : users) {
            user.getProducts().remove(product);
        }
        userRepository.saveAll(users);

        productRepository.delete(product);
    }
}
