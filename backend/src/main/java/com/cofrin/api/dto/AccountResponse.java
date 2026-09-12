package com.cofrin.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cofrin.api.entity.Account;
import com.cofrin.api.enums.AccountType;

public record AccountResponse(
        Long id,
        String name,
        AccountType type,
        BigDecimal initialBalance,
        LocalDateTime createdAt) {

    public static AccountResponse fromEntity(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getName(),
                account.getType(),
                account.getInitialBalance(),
                account.getCreatedAt());
    }

}
