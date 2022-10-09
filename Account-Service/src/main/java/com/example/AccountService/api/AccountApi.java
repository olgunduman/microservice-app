package com.example.AccountService.api;

import com.example.AccountService.entity.Account;
import com.example.AccountService.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountApi {


    private final AccountService accountService;

    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable  String id){

    return ResponseEntity.ok(accountService.get(id));

    }
    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable  String id, @RequestBody Account account){
        return ResponseEntity.ok(accountService.update(id,account));

    }

    @DeleteMapping
    public void delete(String id){

        accountService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAll(){

        return ResponseEntity.ok(accountService.findAll());
    }
    }


