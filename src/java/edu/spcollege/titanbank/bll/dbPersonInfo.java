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
    private String prefixTitle = "";
    private String lastName = "";
    private String firstName = "";
    private String middleName = "";
    private String gender = "";
    private java.util.Date birthDate = null;
    private String suffix = "";
    private String address1 = "";
    private String address2 = "";
    private String city = "";
    private String country = "";
    private String state = "";
    private String emailAddress = "";
    private String postalCode = "";
    private String phone1 = "";
    
    //
    private DBConnect dbconnect;
    
    public dbPersonInfo(int personID) {
        this.personID = personID;
    }
    
    public ResultSet retrieveInfo() throws SQLException {
        System.out.println("retrieveInfo: "+personID);
        Connection conn = null;
        Properties connectionProps = new Properties();
        //these two need to be filled in with the correct database information
        connectionProps.put("user", "databaseusername");
        connectionProps.put("password", "databasepassword");
        
        ResultSet rs = null;
        
        dbconnect = new DBConnect(); 
        
        try  {
            //conn = DriverManager.getConnection("databaseURL", connectionProps);
            conn = dbconnect.getConn();

            String query = "SELECT prefixtitle, firstname, lastname, middlename, suffix, address1, address2, "
                    + "city, country, state, postalcode, emailaddress, phone1 FROM person WHERE personid=" +
                    personID;
            System.out.println("query: " + query); 
            
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            System.out.println("executeQuery...");
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                prefixTitle = rs.getString("prefixtitle");
                lastName = rs.getString("lastname");
                firstName = rs.getString("firstname");
                middleName = rs.getString("middlename");
                suffix = rs.getString("suffix");
                address1 = rs.getString("address1");
                city = rs.getString("city");
                country = rs.getString("country");
                address2 = rs.getString("address2");
                state = rs.getString("state");
                emailAddress = rs.getString("emailaddress");
                postalCode = rs.getString("postalcode");
                phone1 = rs.getString("phone1");
            }
                

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        finally {
           conn.close();
        }
        System.out.println("Return rs...");
        return rs;
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
    
    // Getters and Setters
    
    public String getPrefixTitle() {
	return prefixTitle;
    }
    public void setPrefixTitle(String prefixTitle) {
	this.prefixTitle = prefixTitle;
    } 
    
    public String getLastName() {
	return lastName;
    }
    public void setLastName(String lastName) {
	this.lastName = lastName;
    } 
    
    public String getFirstName() {
	return firstName;
    }     
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getMiddleName() {
	return middleName;
    }
    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    public java.util.Date getBirthDate() {
	return birthDate;
    }
    public void setBirthDate(java.util.Date birthDate) {
	this.birthDate = birthDate;
    }
    
    public String getGender() {
	return gender;
    }
    public void setGender(String gender) {
	this.gender = gender;
    }
    
    public String getSuffix() {
	return suffix;
    }
    public void setSuffix(String suffix) {
	this.suffix = suffix;
    }
    
    public String getAddress1() {
	return address1;
    }
    public void setAddress1(String address1) {
	this.address1 = address1;
    }
    
    public String getAddress2() {
	return address2;
    }
    public void setAddress2(String address2) {
	this.address2 = address2;
    }
    
    public String getCity() {
	return city;
    }
    public void setCity(String city) {
	this.city = city;
    }
    
    public String getCountry() {
	return country;
    }
    public void setCountry(String country) {
	this.country = country;
    }
    
    public String getState() {
	return state;
    }
    public void setState(String state) {
	this.state = state;
    }
    
    public String getPostalCode() {
	return postalCode;
    }
    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }
    
    public String getEmailAddress() {
	return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }
    
    public String getPhone1() {
	return phone1;
    }
    public void setPhone1(String phone1) {
	this.phone1 = phone1;
    }
}
