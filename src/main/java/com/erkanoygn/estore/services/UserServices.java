package com.erkanoygn.estore.services;

import com.erkanoygn.estore.dto.UserDto;

import java.util.List;

public interface UserServices {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUser();
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long userId);

    void deleteProductById(Long userId,Long productId);

    void addProduct(Long userId, Long productId);
}
