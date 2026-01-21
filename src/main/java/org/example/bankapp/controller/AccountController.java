package org.example.bankapp.controller;

import jakarta.validation.Valid;

import org.example.bankapp.api.ApiResponse;
import org.example.bankapp.dto.AccountRequestDto;
import org.example.bankapp.dto.AccountResponseDto;
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
    public ResponseEntity<ApiResponse<AccountResponseDto>> createAccount(
            @Valid @RequestBody AccountRequestDto requestDto) {
        AccountResponseDto response = accountService.createAccount(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

}
