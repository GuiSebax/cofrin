package com.cofrin.api.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cofrin.api.dto.CategoryResponse;
import com.cofrin.api.dto.CreateCategoryRequest;
import com.cofrin.api.entity.Category;
import com.cofrin.api.entity.User;
import com.cofrin.api.exception.ResourceNotFoundException;
import com.cofrin.api.repository.CategoryRepository;
import com.cofrin.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryResponse create(CreateCategoryRequest request, UUID userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário", userId));

        Category category = new Category();
        category.setName(request.name());
        category.setType(request.type());
        category.setColor(request.color());
        category.setUser(user);

        Category response = categoryRepository.save(category);

        return CategoryResponse.fromEntity(response);

    }

}
