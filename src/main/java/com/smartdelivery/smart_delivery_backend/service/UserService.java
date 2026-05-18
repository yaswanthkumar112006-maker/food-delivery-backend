package com.smartdelivery.smart_delivery_backend.service;

import com.smartdelivery.smart_delivery_backend.dto.UserRequestDto;
import com.smartdelivery.smart_delivery_backend.entity.User;
import com.smartdelivery.smart_delivery_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.smartdelivery.smart_delivery_backend.exception.UserAlreadyExistsException;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequestDto userRequestDto) {
        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already exists");
        }
        User user = new User();


        user.setFullName(userRequestDto.getFullName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());

        return userRepository.save(user);
    }
}