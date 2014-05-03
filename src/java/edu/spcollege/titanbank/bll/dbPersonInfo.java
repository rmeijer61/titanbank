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
public class dbPersonInfo {
    
    private int personID;
    
    public dbPersonInfo(int personID) {
        this.personID = personID;
    }
    
    public ResultSet retrieveInfo() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        //these two need to be filled in with the correct database information
        //connectionProps.put("user", "databaseusername");
        //connectionProps.put("password", "databasepassword");
        connectionProps.put("user", "root");
        connectionProps.put("password", "sesame");
        
        
        ResultSet rs = null;
        
        try  {
            conn = DriverManager.getConnection("databaseURL", connectionProps);

            String query = "SELECT prefixtitle, firstname, lastname, middlename, suffix, address1, address2, "
                    + "city, country, state, postalcode, emailaddress, phone1 FROM person WHERE personid=" +
                    personID;
             
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            rs = preparedStatement.executeQuery();
            

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        finally {
           conn.close();
           return rs;

        }
    }
    
    public void updatePersonInfo(ArrayList<String> stringList) throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        //these two need to be filled in with the correct database information
        connectionProps.put("user", "databaseusername");
        connectionProps.put("password", "databasepassword");
        
        try  {
            conn = DriverManager.getConnection("databaseURL", connectionProps);

            String query = "UPDATE person SET prefixtitle=" + stringList.get(0) + " firstname=" + stringList.get(1) + " middlename=" 
                    +  stringList.get(2) + " lastname=" + stringList.get(3) + " suffix=" + stringList.get(4) + " address1=" 
                    + stringList.get(5) + " address2=" + stringList.get(6) + " city=" + stringList.get(7) + " state=" + stringList.get(8)
                    + " postalcode=" + stringList.get(9) + " country=" + stringList.get(10) + " emailaddress=" + stringList.get(11) 
                    + " phone1=" + stringList.get(12) + " FROM person WHERE personid=" + personID;
             
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
