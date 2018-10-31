package com.example.demo.service;

import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

}
