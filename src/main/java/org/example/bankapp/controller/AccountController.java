package org.example.bankapp.controller;

import jakarta.validation.Valid;
import org.example.bankapp.dto.AccountRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @PostMapping
    public ResponseEntity<String> createAccount(@Valid @RequestBody AccountRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Account created successfully with initial balance : " + requestDto.getBalance());
    }

}
