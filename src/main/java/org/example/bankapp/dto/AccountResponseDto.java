package org.example.bankapp.dto;

import java.math.BigDecimal;

public class AccountResponseDto {
    private Long id;
    private BigDecimal balance;

    public AccountResponseDto(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }


    public BigDecimal getBalance() {
        return balance;
    }
}
