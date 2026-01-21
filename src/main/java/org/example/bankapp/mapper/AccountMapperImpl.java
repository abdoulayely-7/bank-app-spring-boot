package org.example.bankapp.mapper;

import org.example.bankapp.dto.AccountRequestDto;
import org.example.bankapp.dto.AccountResponseDto;
import org.example.bankapp.entity.Account;

public class AccountMapperImpl implements AccountMapperInterface {

    @Override
    public Account dtoToEntity(AccountRequestDto dto) {

        Account account = new Account(dto.getBalance());
        account.setBalance(dto.getBalance());
        return account;
    }

    @Override
    public AccountResponseDto entityToResponseDto(Account account) {
        return new AccountResponseDto(
                account.getId(),
                account.getBalance());
    }

}
