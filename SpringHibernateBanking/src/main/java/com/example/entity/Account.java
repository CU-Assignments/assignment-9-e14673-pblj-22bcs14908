package com.example.entity;



import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String owner;
    private double balance;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}

    // Getters, Setters, Constructors
    
}
