package com.smartdelivery.smart_delivery_backend.controller;

import com.smartdelivery.smart_delivery_backend.dto.UserRequestDto;
import com.smartdelivery.smart_delivery_backend.entity.User;
import com.smartdelivery.smart_delivery_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.saveUser(userRequestDto);
    }
}