package com.example.client;

import com.example.client.contract.AccountDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("account-service")
public interface AccountServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/account/{id}")
     ResponseEntity<AccountDto> get(@PathVariable  String id);
}

