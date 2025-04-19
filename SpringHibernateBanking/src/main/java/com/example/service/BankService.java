package com.example.service;


import com.example.dao.AccountDAO;
import com.example.entity.Account;
import com.example.entity.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Account from = accountDAO.getAccount(fromId);
        Account to = accountDAO.getAccount(toId);

        if (from == null || to == null) throw new RuntimeException("Invalid account(s)");
        if (from.getBalance() < amount) throw new RuntimeException("Insufficient funds!");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountDAO.updateAccount(from);
        accountDAO.updateAccount(to);

        Transaction tx = new Transaction();
        tx.setFromAccountId(fromId);
        tx.setToAccountId(toId);
        tx.setAmount(amount);
        tx.setStatus("SUCCESS");

        sessionFactory.getCurrentSession().save(tx);
    }
}

