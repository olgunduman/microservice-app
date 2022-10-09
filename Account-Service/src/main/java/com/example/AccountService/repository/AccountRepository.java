package com.example.AccountService.repository;

import com.example.AccountService.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


public interface AccountRepository extends CassandraRepository<Account,String> {
}

