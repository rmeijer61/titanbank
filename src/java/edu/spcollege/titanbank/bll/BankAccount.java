package edu.spcollege.titanbank.bll;

import java.util.Date;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Locale;

public class BankAccount implements Serializable {
    public enum AccountType {
        SAVINGS,
        CHECKINGS
    }
    
    private Currency currency;
    private int customerId = 0;
    private DBPerson person;
    private Customer customer;
    private double balance;
    private final AccountType typeOfAccount;
    
    public BankAccount() throws SQLException, ClassNotFoundException {
        this.customer = new Customer(customerId);
        this.typeOfAccount = AccountType.SAVINGS;
    }
    
    public BankAccount(Customer customer, double startingBalance, AccountType typeOfAccount){
        this.customer = customer;
        this.balance = startingBalance;
        this.typeOfAccount = typeOfAccount;
    }
    
    public BankAccount(Customer customer, AccountType typeOfAccount){
        this.customer = customer;
        this.typeOfAccount = typeOfAccount;
        
    }
    
    public double getBalance(){
        return this.balance;
    }
    
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
    
    public AccountType getAccountType() {
        return this.typeOfAccount;
    }
    
    public String getFormatted(double amount) {
        currency = new Currency();
        currency.setLocale(Locale.US);
        currency.setAmount(amount);
        return currency.getFormat();
    }
   
}
    
    
    
