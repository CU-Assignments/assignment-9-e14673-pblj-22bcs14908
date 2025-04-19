package com.example;


import com.example.entity.Account;
import com.example.dao.AccountDAO;
import com.example.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountDAO dao = context.getBean(AccountDAO.class);
        BankService service = context.getBean(BankService.class);

        // Setup: Add 2 accounts
        Account a1 = new Account(); a1.setOwner("Alice"); a1.setBalance(1000);
        Account a2 = new Account(); a2.setOwner("Bob"); a2.setBalance(500);

        dao.saveAccount(a1);
        dao.saveAccount(a2);

        // SUCCESSFUL transfer
        try {
            service.transfer(a1.getId(), a2.getId(), 200);
            System.out.println("Transfer success.");
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        // FAILED transfer (insufficient funds)
        try {
            service.transfer(a2.getId(), a1.getId(), 1000);
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }
    }
}
