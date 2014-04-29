/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class SavingsAccount extends Account {
    // Test balances
    private double beginBalance = 0.0;
    private String beginBalanceFormatted;
    private double depositTotal = 0.0;
    private String depositTotalFormatted;
    private double withdrawalTotal = 0.0;
    private String withdrawalTotalFormatted;
    private double balance = 0.0;
    private String balanceFormatted;
    
    public SavingsAccount() throws SQLException, ClassNotFoundException {
        super();
        this.beginBalance = 500.0;
        this.depositTotal = 350.0;
        this.withdrawalTotal = 50.0;
        this.balance = 800.0;
    }
    
    public double getBeginBalance() {
        return this.beginBalance;
    }
    
    public String getBeginBalanceFormatted() {
        return getFormatted(this.beginBalance);
    }
            
    public double getDepositTotal() {
        return this.depositTotal;
    }
    
    public String getDepositTotalFormatted() {
        return getFormatted(this.depositTotal);
    }
            
    public double getWithdrawalTotal() {
        return this.withdrawalTotal;
    }
    
    public String getWithdrawalTotalFormatted() {
        return getFormatted(this.withdrawalTotal);
    }
    
    @Override
    public double getBalance() {
        return this.balance;
    }
    
    public String getBalanceFormatted() {
        return getFormatted(this.balance);
    }
}
