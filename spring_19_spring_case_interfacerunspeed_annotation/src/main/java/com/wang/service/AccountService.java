package com.wang.service;

import com.wang.domain.Account;

import java.util.List;

public interface AccountService {
    void put(Account account);
    void deleteById(Integer id);
    void update(Account account);
    List<Account> findAll();
    Account findById(Integer id);
}
