/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author rmeijer
 */
public class User implements Serializable{
    private int userId = 0;
    private String userName = "";
    private String userType = "";
    private String password = "";
    private int customerId = 0;
    boolean isAuthenticated = false;
    
    public User() {
        this.userId = 0;
        this.userName = "";
        this.userType = "";
        this.password = "";
        this.customerId = 0;
    }

    public User(String userName, String userType, String password) throws SQLException, ClassNotFoundException {
        queryUser(userName, userType, password);
    }
    
    public int insertUser(String userName, String userType, String password, int customerId) throws SQLException {
        this.userName = userName;
        this.userType = userType;
        this.password = password;
        this.customerId = customerId;
        System.out.println("Create DBUser");
        DBUser dbuser = new DBUser();
        System.out.println("Call DBUser.insertUser");
        this.userId = dbuser.insertUser(this);
        
        return userId;
    }
    
    public boolean queryUser(String userName, String userType, String password) throws SQLException, ClassNotFoundException {
        DBUser dbuser = new DBUser();
        dbuser.queryUser(userName, userType, password);
        
        this.userId = dbuser.getUserId();
        this.userName = dbuser.getUserName();
        this.userType = dbuser.getUserType();
        this.password = getPassword();
        this.customerId = dbuser.getCustomerId();
        this.isAuthenticated = dbuser.getIsAuthenticated();
        return this.isAuthenticated;
    }
    
    // Getters and Setters
    public int getUserId() {
        return this.userId;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getUserType() {
        return this.userType;
    }
    public String getPassword() {
        return this.password;    
    }
    public int getCustomerId() {
        return this.customerId;
    }
    public boolean getIsAuthenticated() {
        return this.isAuthenticated;
    }
}    