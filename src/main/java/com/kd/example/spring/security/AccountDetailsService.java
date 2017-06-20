package com.kd.example.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kd.example.spring.dao.AccountDao;
import com.kd.example.spring.model.Account;

public class AccountDetailsService implements UserDetailsService {
    @Autowired
    AccountDao accountDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDao.loadUserByUsername(username);
        return account;
    }

}
