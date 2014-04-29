/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.util.ArrayList;

/**
 *
 * @author rmeijer
 */
public class UserLoginStatus {
    private User user;
    private String userName = "";
    private final java.util.Date loginDate = new java.util.Date();
    
    // loggedIn will contain logins for a particular user, not all users
    // There will always be a check for multiple logins and cleanup will
    // be done if multiple logins are discovered
    private ArrayList<UserLoginStatus> loggedIn;
    
    public UserLoginStatus(User user) {
        this.userName = user.getUserName();
    }
    
    // Method for checking the login status
    public UserLoginStatus(String userid) {
        this.userName = userid;
    }
    
    public java.util.Date getLoginDate() {
        return loginDate;
    }
    
    public boolean updateUserLoginActivity() {
        // TODO - update the database
        return true;
    }
    
    public boolean removeUserLoginActivity(User user) {
        // TODO - Currently, there is no data
        // The ArrayList should be populated via database query
        this.loggedIn = new ArrayList<>();
        
        // Find the user login(s)
        find(user.getUserName());
        
        // Remove the logins from the database
        for(UserLoginStatus ula: loggedIn){
            if (ula.getUserName().equals(userName)) {
                // Remove the login from the database
            }
        }
        return true;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public boolean isLoggedIn(String userid){
       return find(userid) != null;
    }
    
    private ArrayList<UserLoginStatus> find(String userid){
        // TODO - Currently, there is no data
        // The ArrayList should be populated via database query
        this.loggedIn = new ArrayList<>();
        
        // Multiple login attempts?

        for(UserLoginStatus ula: loggedIn){
            if (ula.getUserName().equals(userName))
                return loggedIn;
        }
        return loggedIn;
    }
}
