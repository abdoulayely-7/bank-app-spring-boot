package org.example.bankapp.service;

import org.example.bankapp.dto.AccountRequestDto;
import org.example.bankapp.dto.AccountResponseDto;

public interface AccountServiceInterface {
    AccountResponseDto createAccount(AccountRequestDto dto);
}
