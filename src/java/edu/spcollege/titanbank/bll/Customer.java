/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.SQLException;

/**
 *
 * @author rmeijer
 */


public class Customer {
    private int customerId = 0;
    private int personId = 0;
    private String userId = "";
    private String status = "";
    private String description = "New customer";

    public Customer() {
        this.customerId = 0;
    }
    
    public Customer(int customerId) throws SQLException, ClassNotFoundException {
        this.customerId = customerId;
        System.out.println("Customer id: "+customerId);
        queryCustomer(customerId);
    }
    
    public int insertCustomer(String columnName, int value) throws SQLException {
        if (columnName.equals("personId")) {
            this.personId = value;
        }
        
        DBCustomer dbcustomer = new DBCustomer();
        dbcustomer.insertCustomer(this);
        
        if (dbcustomer.getCustomerId() != 0) {
            customerId = dbcustomer.getCustomerId();
            System.out.println("Customer id: "+customerId);
         }
        else {
            System.out.println("Failed to get a customer id");
        }
        return customerId;
    }
    
    public void queryCustomer(int CustomerId) throws SQLException, ClassNotFoundException {
        DBCustomer dbcustomer = new DBCustomer();
        dbcustomer.queryCustomer(customerId);
        this.customerId = dbcustomer.getCustomerId();
        this.personId = dbcustomer.getPersonId();
        this.userId = dbcustomer.getUserId();
        this.description = dbcustomer.getDescription();
        this.status = dbcustomer.getStatus();
    }
    
    public int getCustomerId() {
        return customerId;
    }
    public int getPersonId() {
        return personId;
    }
    public String getUserId() {
        return userId;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
}
