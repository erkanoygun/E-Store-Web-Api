package com.erkanoygn.estore.services;

import com.erkanoygn.estore.dto.UserDto;

public interface UserServices {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);

    void deleteUser(Long userId);
}
