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
public class Logout {
    private boolean isRemoved = false;
    
    public Logout(User user) {
        // Note: simulation
 
        UserLoginStatus userLoginStatus = new UserLoginStatus(user);
        if (userLoginStatus.isLoggedIn(user.getUserName())) {
            userLoginStatus.removeUserLoginActivity(user);
             // Do other logout stuff
            this.isRemoved = true;
        }
    }
    
    public boolean isRemoved() {
        return this.isRemoved;
    }
}