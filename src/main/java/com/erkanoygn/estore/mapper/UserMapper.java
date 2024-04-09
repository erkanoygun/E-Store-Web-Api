package com.erkanoygn.estore.mapper;

import com.erkanoygn.estore.dto.UserDto;
import com.erkanoygn.estore.entitiy.Product;
import com.erkanoygn.estore.entitiy.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto mapToUserDto(User user){

        List<Long> productIds = user.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toList());

        return new UserDto(
                user.getId(),
                productIds,
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getGender(),
                user.getNationalId(),
                user.getPhoneNo(),
                user.getBirthDate(),
                user.getHomeAddress()
        );
    }

    public static User mapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
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

        if(userDto.getProductIds() != null) {
            List<Product> products = userDto.getProductIds().stream()
                    .map(productId -> {
                        Product product = new Product();
                        product.setId(productId);
                        return product;
                    })
                    .collect(Collectors.toList());
            user.setProducts(products);
        }

        return user;
    }

}
