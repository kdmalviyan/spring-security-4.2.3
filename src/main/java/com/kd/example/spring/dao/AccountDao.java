package com.kd.example.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.example.spring.model.Account;

@Service
public class AccountDao {
    @Autowired
    SessionFactory sessionFactory;

    public Account loadUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Account account = (Account) session.get(Account.class, 1);
        tx.commit();
        session.close();
        return account;
    }

    public void save(Account account) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(account);
        tx.commit();
        session.close();
    }

}
