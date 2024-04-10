package com.erkanoygn.estore.services.Impl;

import com.erkanoygn.estore.dto.ProductDto;
import com.erkanoygn.estore.entitiy.Product;
import com.erkanoygn.estore.entitiy.User;
import com.erkanoygn.estore.exception.ResourceNotFoundException;
import com.erkanoygn.estore.mapper.ProductMapper;
import com.erkanoygn.estore.repository.ProductRepository;
import com.erkanoygn.estore.repository.UserRepository;
import com.erkanoygn.estore.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServicesImpl implements ProductServices {

    private ProductRepository productRepository;

}
