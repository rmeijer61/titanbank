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
 * 
 * The Authenticate class authenticates the userid and password and updates
 * the user login activity
 */
public class Authenticate {
    private boolean authenticated = false;
    private User userid;
    private String customerId = "";
    private ArrayList<UserLoginStatus> loggedIn;
    
    public Authenticate(String lookupUserid, String lookupPassword) {
        try {
            // Note: For best practice security, the password is separate
            userid = new User(lookupUserid, lookupPassword);
            this.authenticated = userid.isAuthenticated();
            // TODO - The customer id is accessed via the Userid object
            this.customerId = userid.getCustomerId();
            updateUserLoginActivity(userid);
        }
        catch (UserNotFoundException ex) {
            // TODO
        }
    }
    
    public boolean isAuthenticated() {
        return this.authenticated;
    }
    
    public String getCustomerId() {
        return userid.getCustomerId();
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
