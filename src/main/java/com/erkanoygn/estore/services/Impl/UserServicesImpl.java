package com.erkanoygn.estore.services.Impl;

import com.erkanoygn.estore.dto.UserDto;
import com.erkanoygn.estore.entitiy.Product;
import com.erkanoygn.estore.entitiy.User;
import com.erkanoygn.estore.exception.ResourceNotFoundException;
import com.erkanoygn.estore.mapper.UserMapper;
import com.erkanoygn.estore.repository.ProductRepository;
import com.erkanoygn.estore.repository.UserRepository;
import com.erkanoygn.estore.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServicesImpl implements UserServices {

    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User is not exist with given id: " + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(("User is not exists with given id: " + id))
        );

        /*List<Long> productIds = userDto.getProductIds();
        List<Product> products = productRepository.findAllById(productIds);

        user.setProducts(products);*/

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setNationalId(userDto.getNationalId());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setBirthDate(userDto.getBirthDate());
        user.setHomeAddress(userDto.getHomeAddress());

        User updateUser = userRepository.save(user);

        return UserMapper.mapToUserDto(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(("User is not exists with given id: " + userId))
        );

        userRepository.deleteById(userId);
    }

    @Override
    public void deleteProductById(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        List<Product> products = user.getProducts();

        products.removeIf(product -> product.getId().equals(productId));
        user.setProducts(products);

        userRepository.save(user);
    }

    @Override
    public void addProduct(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        List<Product> products = user.getProducts();
        products.add(product);
        user.setProducts(products);

        userRepository.save(user);
    }
}
