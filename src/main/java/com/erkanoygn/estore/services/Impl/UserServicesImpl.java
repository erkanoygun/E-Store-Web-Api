package com.erkanoygn.estore.services.Impl;

import com.erkanoygn.estore.dto.UserDto;
import com.erkanoygn.estore.entitiy.User;
import com.erkanoygn.estore.mapper.UserMapper;
import com.erkanoygn.estore.repository.UserRepository;
import com.erkanoygn.estore.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class UserServicesImpl implements UserServices {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);

        if(user.getProducts() == null){
            user.setProducts(new ArrayList<>());
        }

        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }
}
