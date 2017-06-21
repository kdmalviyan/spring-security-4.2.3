package com.kd.example.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
        Criteria criteria = session.createCriteria(Account.class);
        criteria.add(Restrictions.eq("username", username));
        @SuppressWarnings("unchecked")
        List<Account> accounts = criteria.list();
        Account account = null;
        if (accounts != null && !accounts.isEmpty()) {
            account = accounts.get(0);
        }
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
