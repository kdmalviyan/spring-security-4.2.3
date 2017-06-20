package com.kd.example.spring.dao;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kd.example.spring.model.Account;
import com.kd.example.spring.model.Role;

@Service
public class AccountDao {
    @Autowired
    StandardPasswordEncoder passwordEncoder;

    public Account loadUserByUsername(String username) {
        Account account = new Account();
        account.setAccountNonExpired(true);
        account.setAccountNonLocked(true);
        account.setCredentialsNonExpired(true);
        account.setEnabled(true);
        account.setUsername("kuldeep");
        account.setPassword(passwordEncoder.encode("kuldeep"));
        Set<Role> roles = new TreeSet<>();
        roles.add(new Role("Admin"));
        account.setRoles(roles);
        return account;
    }

}
