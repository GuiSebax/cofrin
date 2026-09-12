package com.cofrin.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import com.cofrin.api.entity.Category;

import com.cofrin.api.enums.CategoryType;

public record CategoryResponse(
        UUID id,
        String name,
        CategoryType type,
        String color,
        LocalDateTime createdAt) {

    public static CategoryResponse fromEntity(Category category) {
        return new CategoryResponse(category.getId(), category.getName(), category.getType(), category.getColor(),
                category.getCreatedAt());
    }

}
