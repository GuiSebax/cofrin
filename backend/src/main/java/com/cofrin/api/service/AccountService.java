package com.cofrin.api.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cofrin.api.dto.AccountResponse;
import com.cofrin.api.dto.CreateAccountRequest;
import com.cofrin.api.entity.Account;
import com.cofrin.api.entity.User;
import com.cofrin.api.exception.ResourceNotFoundException;
import com.cofrin.api.repository.AccountRepository;
import com.cofrin.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountResponse create(CreateAccountRequest request, UUID userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário", userId));

        Account account = new Account();
        account.setName(request.name());
        account.setType(request.type());
        account.setInitialBalance(request.initialBalance());
        account.setUser(user);

        return AccountResponse.fromEntity(accountRepository.save(account));

    }

}
