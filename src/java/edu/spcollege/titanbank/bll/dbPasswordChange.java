package edu.spcollege.titanbank.bll;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxximilianseijo
 */
public class dbPasswordChange {
    
    private int userID;
    private String password = "";
    
    private DBConnect dbconnect;
    
    public dbPasswordChange(int userID) {
        this.userID = userID;
    }
    
    public String retrievePassword() throws SQLException {
        System.out.println("retrieveInfo: "+ userID);
        Connection conn = null;
        
        dbconnect = new DBConnect(); 
        
        try  {
            //conn = DriverManager.getConnection("databaseURL", connectionProps);
            conn = dbconnect.getConn();
            
            ResultSet rs = null;

            String query = "SELECT password FROM user WHERE userid=" + userID;
            System.out.println("query: " + query); 
            
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            System.out.println("executeQuery...");
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                password = rs.getString("password");
                
            }
                

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        finally {
           conn.close();
        }
        System.out.println("Return rs...");
        return password;
    }
    
    public void updatePassword(String newPassword) throws SQLException {
        Connection conn = null;
        
        dbconnect = new DBConnect();
        
        try  {
            conn = dbconnect.getConn();

            String query = "UPDATE user SET password=" + newPassword + " WHERE userid=" + userID;
             
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.executeUpdate();
            

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        finally {
           conn.close();


        }
        
    }
    
    
}
