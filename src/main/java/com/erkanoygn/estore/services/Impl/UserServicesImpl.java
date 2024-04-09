package com.erkanoygn.estore.services.Impl;

import com.erkanoygn.estore.dto.UserDto;
import com.erkanoygn.estore.entitiy.User;
import com.erkanoygn.estore.exception.ResourceNotFoundException;
import com.erkanoygn.estore.mapper.UserMapper;
import com.erkanoygn.estore.repository.UserRepository;
import com.erkanoygn.estore.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServicesImpl implements UserServices {

    private UserRepository userRepository;
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
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(("User is not exists with given id: " + userId))
        );

        userRepository.deleteById(userId);
    }
}
