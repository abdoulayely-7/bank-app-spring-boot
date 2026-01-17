package org.example.bankapp.service;

import java.math.BigDecimal;

import org.example.bankapp.entity.Account;

public interface AccountServiceInterface {
    Account createAccount(BigDecimal balance);
}
