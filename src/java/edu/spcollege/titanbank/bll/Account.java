package edu.spcollege.titanbank.bll;

import java.util.Date;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Locale;

public class Account implements Serializable {
    private Currency currency;
    //
    private int accountNum = 0;
    private int customerId = 0;
    private String accountType;
    public enum AccountType {
        SAVINGS,
        CHECKINGS
    }
    private double balance = 0;
    private boolean isFound = false;
     
    public Account() throws SQLException, ClassNotFoundException {
        this.accountNum = 0;
        this.customerId = 0;
        this.accountType = "";
        this.balance = 0;
        this.isFound = false;
    }
    
    public Account(int customerId, String accountType, double startingBalance){
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = startingBalance;
    }
    
    public Account(int customerId, String accountType) throws SQLException, ClassNotFoundException{
        this.customerId = customerId;
        this.accountType = accountType;
        this.isFound = queryAccount(customerId, accountType);
    }
    
    // Data Access
    public int insertAccount(String accountType, int customerId, double balance) throws SQLException {
        this.accountType = accountType;
        this.customerId = customerId;
        this.balance = balance;
        System.out.println("Create DBAccount");
        DBAccount dbaccount = new DBAccount();
        System.out.println("Call DBAccount.insertAccount");
        this.accountNum = dbaccount.insertAccount(this);
        
        return this.accountNum;
    }
    
    public boolean queryAccount(int customerId, String accountType) throws SQLException, ClassNotFoundException {
        DBAccount dbaccount = new DBAccount();
        dbaccount.queryAccount(accountType, customerId);
        
        this.accountNum = dbaccount.getAccountNum();
        this.accountType = dbaccount.getAccountType();
        this.customerId = getCustomerId();
        this.balance = dbaccount.getBalance();
        this.isFound = dbaccount.getIsFound();
        return this.isFound;
    }
    
    // TODO
    public boolean hasSufficientFunds(double amount){
        return this.balance >= amount;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException{
        if (hasSufficientFunds(amount))
            this.balance -= amount;
        else
            throw new InsufficientFundsException();
    }
    
    public void deposit(double amount){
        this.balance += amount;
    }
    
    // Getters and Setters
    public int getAccountNum() {
        return this.accountNum;
    }
    
    public String getAccountType() {
        return this.accountType;
    }

    public int getCustomerId() {
        return this.customerId;
    }
    
    public String getFormatted(double amount) {
        currency = new Currency();
        currency.setLocale(Locale.US);
        currency.setAmount(amount);
        return currency.getFormat();
    }
    
    public double getBalance(){
        return this.balance;
    }
    public boolean getIsFound() {
        return this.isFound;
    }
   
}
    
    
    
