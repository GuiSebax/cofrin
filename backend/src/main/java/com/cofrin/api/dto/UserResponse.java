package com.cofrin.api.dto;

import java.time.LocalDateTime;

import com.cofrin.api.entity.User;

public record UserResponse(
		Long id,
		String name,
		String email,
		LocalDateTime createdAt) {

	public static UserResponse fromEntity(User user) {
		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt());
	}
}