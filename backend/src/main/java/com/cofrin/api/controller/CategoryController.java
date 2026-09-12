package com.cofrin.api.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cofrin.api.dto.CategoryResponse;
import com.cofrin.api.dto.CreateCategoryRequest;
import com.cofrin.api.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest request,
            @RequestParam UUID userId) {

        CategoryResponse response = categoryService.create(request, userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
