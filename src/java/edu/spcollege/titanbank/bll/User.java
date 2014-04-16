/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.io.Serializable;

/**
 *
 * @author rmeijer
 */
public class User implements Serializable{
    private final String userid = "cop2806";
    Password password;
    private final String lookupUserid;
    private final String customerId;
    private final String firstName = "Rick";
    private final String lastName = "Meijer";
    boolean authenticated = false;
    
    public User() {
        // For simulation
        this.lookupUserid = "cop2806";
        this.customerId = "1234";
    }
    
    public User(String userid, String lookupPassword) throws UserNotFoundException {
        this.lookupUserid = userid;
        // Query the userid
        
        // TODO - Query - customerid stored with the userid
        customerId = "1234";
        
        if (this.userid.equals(userid)) {
            try {
                // For best practice, the password is separate
                password = new Password(lookupPassword);
                this.authenticated = password.isValidPassword();
                // TODO - Customer id
                
            }
            catch (InvalidPasswordException ex) {
                // TODO
            }
        }
    }
    
    public boolean isAuthenticated() {
        return authenticated;
    }
    
    public String getUserid() {
        return this.userid;
    }
    
    public String getCustomerId() {
        return this.customerId;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
}    