package com.cofrin.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.cofrin.api.entity.User;

public record UserResponse(
		UUID id,
		String name,
		String email,
		LocalDateTime createdAt) {

	public static UserResponse fromEntity(User user) {
		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt());
	}
}