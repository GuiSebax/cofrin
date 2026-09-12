package com.cofrin.api.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cofrin.api.dto.AccountResponse;
import com.cofrin.api.dto.CreateAccountRequest;
import com.cofrin.api.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest request,
            @RequestParam UUID userId) {
        AccountResponse response = service.create(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
