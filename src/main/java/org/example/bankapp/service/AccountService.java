package org.example.bankapp.service;

import org.example.bankapp.dto.AccountRequestDto;
import org.example.bankapp.dto.AccountResponseDto;
import org.example.bankapp.entity.Account;
import org.example.bankapp.exception.BusinessException;
import org.example.bankapp.mapper.AccountMapperImpl;
import org.example.bankapp.mapper.AccountMapperInterface;
import org.example.bankapp.repository.AccountRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Locale;

@Service
@Transactional

public class AccountService implements AccountServiceInterface {

    private AccountRepository accountRepository;
    private MessageSource messageSource;
    private AccountMapperInterface accountMapper;

    public AccountService(AccountRepository accountRepository, MessageSource messageSource,
            AccountMapperInterface accountMapper) {
        this.accountRepository = accountRepository;
        this.messageSource = messageSource;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountResponseDto createAccount(AccountRequestDto dto) {
        if (dto.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            String msg = messageSource.getMessage("SOLDE_POSITIF", null, Locale.getDefault());
            throw new BusinessException(msg);
        }
        // Account account = new Account(dto.getBalance());
        Account account = accountMapper.dtoToEntity(dto);
        Account accountSaved = accountRepository.save(account);
        // return new AccountResponseDto(
        // accountSaved.getId(),
        // accountSaved.getBalance());
        return accountMapper.entityToResponseDto(accountSaved);
    }
}
