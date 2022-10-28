package com.example.AccountService.service;

import com.example.AccountService.entity.Account;
import com.example.AccountService.repository.AccountRepository;
import com.example.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;


    public AccountDto get(String id) {

       return modelMapper.map(
               accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"))
               , AccountDto.class);
    }


    @Transactional
    public AccountDto save(AccountDto accountDto) {

        Account account = new Account();
        account.setUsername(accountDto.getUsername());
        account.setName(accountDto.getName());
        account.setSurname(accountDto.getSurname());
        account.setBirthDate(accountDto.getBirthDate());
        account.setEmail(accountDto.getEmail());


        Account returnModel = accountRepository.save(account);
        return modelMapper.map(returnModel, AccountDto.class);


    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {

        Optional<Account> accountById = accountRepository.findById(id);
        if (accountById.isPresent()) {
            Account account = accountById.get();
            account.setName(accountDto.getName());
            account.setSurname(accountDto.getSurname());
            account.setBirthDate(accountDto.getBirthDate());
            accountRepository.save(account);
            return modelMapper.map(account, AccountDto.class);
        } else {
            throw new IllegalArgumentException("Account not found");
        }

    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        accountRepository.delete(account);
    }

    public List<AccountDto> findAll(Pageable pageable) {
        Slice<Account> accounts = accountRepository.findAll(pageable);
        List<AccountDto> accountDtos = accounts.stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());

        return accountDtos;

    }
}
