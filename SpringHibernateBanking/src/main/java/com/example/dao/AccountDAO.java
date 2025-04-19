package com.example.dao;

import com.example.entity.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Account getAccount(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void updateAccount(Account acc) {
        sessionFactory.getCurrentSession().update(acc);
    }

    public void saveAccount(Account acc) {
        sessionFactory.getCurrentSession().save(acc);
    }
}
