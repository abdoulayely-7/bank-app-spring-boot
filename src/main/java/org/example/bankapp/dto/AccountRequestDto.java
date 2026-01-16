package org.example.bankapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class AccountRequestDto {

    @NotNull(message = "{SOLDE_OBLIGATOIRE}")
    @PositiveOrZero(message = "{SOLDE_POSITIF}")
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
