/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rmeijer
 * 
 * The Authenticate class authenticates the userid and password and updates
 * the user login activity
 */
public class AuthenticationService {
    private boolean isAuthenticated = false;
    private User user;
    private String userName;
    private int customerId = 0;
    private ArrayList<UserLoginStatus> loggedIn;
    
    public AuthenticationService(String userName, String userType, String password) throws SQLException, ClassNotFoundException {
        this.user = new User(userName, userType, password);
        this.isAuthenticated = user.queryUser(userName, userType, password);

        // The customer id is accessed via the User object
        this.customerId = user.getCustomerId();
        
        //updateUserLoginActivity(user);
        //}
        //catch (UserNotFoundException ex) {
            // TODO
        //}
    }
    
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    public User getUser() {
        return this.user;
    }
    
    private void updateUserLoginActivity(User userid) {
        // TODO - If already logged in?
        
        UserLoginStatus ula = new UserLoginStatus(userid);
        // TODO - Exceptions should be coded
        if (ula.updateUserLoginActivity()) {
             // TODO   
        }
    }
    

}
