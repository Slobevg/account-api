package com.example.demo.service;

import com.example.demo.model.AccountEntity;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public AccountEntity deposit(Long id, BigDecimal money) {
        AccountEntity account = accountRepository.findOne(id);
        if (account == null) {
            throw new AccountNotFoundException(id);
        }
        account.addMoney(money);
        return account;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public AccountEntity withdraw(Long id, BigDecimal money) {
        AccountEntity account = accountRepository.findOne(id);
        if (account == null) {
            throw new AccountNotFoundException(id);
        }
        account.subtractMoney(money);
        return account;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void transfer(Long from, Long to, BigDecimal money) {
        if (from.equals(to)) {
            return;
        }
        withdraw(from, money);
        deposit(to, money);
    }

}
