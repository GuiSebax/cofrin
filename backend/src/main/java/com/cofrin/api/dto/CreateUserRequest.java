package com.cofrin.api.dto;

public record CreateUserRequest(
        String name,
        String email,
        String password) {
}
