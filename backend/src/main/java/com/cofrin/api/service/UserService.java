package com.cofrin.api.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cofrin.api.dto.CreateUserRequest;
import com.cofrin.api.dto.UserResponse;
import com.cofrin.api.entity.User;
import com.cofrin.api.exception.EmailAlreadyExistsException;
import com.cofrin.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse create(CreateUserRequest request) {

        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Email já cadastrado");
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));

        return UserResponse.fromEntity(userRepository.save(user));
    }
}
