package edu.spcollege.titanbank.bll;

public class UserNotFoundException extends Exception{
    
    public UserNotFoundException(){
        super("User not Found.");
    }
}
