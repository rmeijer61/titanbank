/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

/**
 *
 * @author rmeijer
 */
public class Password {
    private String password = "password";
    private String lookupPassword;
    
    public Password (String lookupPassword) throws InvalidPasswordException {
        this.lookupPassword = lookupPassword;
        // Query password
    }
    
    public boolean isValidPassword(){
        return this.password.equals(lookupPassword);
    }
}
