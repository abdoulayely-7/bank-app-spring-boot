package org.example.bankapp.service;

import org.example.bankapp.dto.AccountRequestDto;
import org.example.bankapp.entity.Account;
import org.example.bankapp.mapper.AccountMapperInterface;
import org.example.bankapp.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapperInterface accountMapper;

    @InjectMocks
    private AccountService accountService;

    @Test
    void should_create_account_when_balance_is_valid() {
        // GIVEN
        AccountRequestDto dto = new AccountRequestDto();
        dto.setBalance(BigDecimal.valueOf(7700));
        Account account = new Account(dto.getBalance());

    }

}
