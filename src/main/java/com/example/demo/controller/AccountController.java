package com.example.demo.controller;

import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping(path = "/deposit")
    public void deposit(@RequestBody DepositRequest request) {
        accountService.deposit(request.getId(), request.getMoney());
    }

    @PostMapping(path = "/withdraw")
    public void withdraw(@RequestBody WithdrawRequest request) {
        accountService.withdraw(request.getId(), request.getMoney());
    }

    @PostMapping(path = "/transfer")
    public void transfer(@RequestBody TransferRequest request) {
        accountService.transfer(request.getFrom(), request.getTo(), request.getMoney());
    }
}
