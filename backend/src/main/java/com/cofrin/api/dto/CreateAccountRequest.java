package com.cofrin.api.dto;

import java.math.BigDecimal;

import com.cofrin.api.enums.AccountType;

public record CreateAccountRequest(
                String name,
                AccountType type,
                BigDecimal initialBalance) {
}
