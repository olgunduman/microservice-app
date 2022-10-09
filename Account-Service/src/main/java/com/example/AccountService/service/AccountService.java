package com.example.AccountService.service;

import com.example.AccountService.entity.Account;
import com.example.AccountService.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;


    public Account get(String id) {

        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }

    public Account save(Account account) {

        return accountRepository.save(account);

    }

    public Account update(String id, Account account) {

            Account createdAccount = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        createdAccount.setUsername(account.getUsername());
        createdAccount.setEmail(account.getEmail());
        createdAccount.setPassword(account.getPassword());
            return accountRepository.save(account);

    }

    public void delete(String id) {

    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
