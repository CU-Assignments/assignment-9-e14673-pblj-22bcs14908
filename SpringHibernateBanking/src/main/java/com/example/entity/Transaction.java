package com.example.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccountId;
    private int toAccountId;
    private double amount;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();


	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public int getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    // Getters, Setters, Constructors
    
}
