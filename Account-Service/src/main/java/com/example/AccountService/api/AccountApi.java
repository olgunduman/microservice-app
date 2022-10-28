package com.example.AccountService.api;

import com.example.AccountService.service.AccountService;
import com.example.client.contract.AccountDto;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<AccountDto> get(@PathVariable  String id){

    return ResponseEntity.ok(accountService.get(id));

    }
    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable  String id, @RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.update(id,account));

    }

    @DeleteMapping
    public void delete(String id){

        accountService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(accountService.findAll(pageable));
    }


}


