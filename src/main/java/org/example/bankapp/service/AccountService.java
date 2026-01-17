package org.example.bankapp.service;

import org.example.bankapp.entity.Account;
import org.example.bankapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@Service
@Transactional

public class AccountService implements AccountServiceInterface {
private AccountRepository accountRepository;
    public  AccountService (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(BigDecimal balance) {
        Account account = new Account(balance);
        return accountRepository.save(account);
    }
}
