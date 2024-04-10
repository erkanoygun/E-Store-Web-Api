package com.erkanoygn.estore.controller;

import com.erkanoygn.estore.dto.UserDto;
import com.erkanoygn.estore.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

    private UserServices userServices;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto savedUser = userServices.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto userDto = userServices.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userServices.getAllUser();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userServices.deleteUser(userId);
        return ResponseEntity.ok("User deleted successful");
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updateUserDto){
        UserDto userDto = userServices.updateUser(userId, updateUserDto);
        return ResponseEntity.ok(userDto);

    }

    @DeleteMapping("deleteProduct/{userId}/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId) {
        userServices.deleteProductById(userId, productId);
        return ResponseEntity.ok("Product with id " + productId + " of user with id " + userId + " deleted successfully");
    }

    @PostMapping("addProduct/{userId}/{productId}")
    public ResponseEntity<String> addProductToUserById(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId) {
        userServices.addProduct(userId, productId);
        return ResponseEntity.ok("Product with id " + productId + " of user with id " + userId + " added successfully");
    }
}
