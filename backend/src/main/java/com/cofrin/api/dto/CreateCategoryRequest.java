package com.cofrin.api.dto;

import com.cofrin.api.enums.CategoryType;

public record CreateCategoryRequest(
        String name,
        CategoryType type,
        String color) {

}
