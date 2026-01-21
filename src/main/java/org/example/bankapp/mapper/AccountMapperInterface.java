package org.example.bankapp.mapper;

import org.example.bankapp.dto.AccountRequestDto;
import org.example.bankapp.dto.AccountResponseDto;
import org.example.bankapp.entity.Account;

public interface AccountMapperInterface {

    Account dtoToEntity(AccountRequestDto dto);

    AccountResponseDto entityToResponseDto(Account account);
}
