package edu.spcollege.titanbank.bll;

import java.util.Date;

public class AccountActivity {
    private String id = "";
    private String customerId = "";
    private String transactionType = "";
    private String transactionId = "";
    private java.util.Date date;
    private String description = "";
    private double amount = 0;
	public AccountActivity(String id, String customerId,
			String transactionType, String transactionId, Date date,
			String description, double amount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.transactionType = transactionType;
		this.transactionId = transactionId;
		this.date = date;
		this.description = description;
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
    
    
}
