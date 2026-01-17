package org.example.bankapp.controller;
import jakarta.validation.Valid;


import org.example.bankapp.dto.AccountRequestDto;
import org.example.bankapp.entity.Account;
import org.example.bankapp.service.AccountServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountServiceInterface accountService;

    public AccountController(AccountServiceInterface accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountRequestDto requestDto) {
        Account account = accountService.createAccount(requestDto.getBalance());
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

}
