/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Person {
    private int personId = 0;
    private String lastName = "";
    private String firstName = "";
    private String middleName = "";
    private java.util.Date birthDate = null;
    private String gender = "";
    private String prefixTitle = "";
    private String suffix = "";
    private String address1 = "";
    private String address2 = "";
    private String city = "";
    private String country = "";
    private String state = "";
    private String postalCode = "";
    private String emailAddress = "";
    private String phone1 = "";
    //
    
    public Person() {
        this.personId = 0; //Insert - value auto by database    
    }
    
    public Person(int personId) throws SQLException, ClassNotFoundException {
        queryPerson(personId);
    }
    
    public int insertPerson() throws SQLException {
        DBPerson dbperson = new DBPerson();
        dbperson.insertPerson(this);
        
        if (dbperson.getPersonId() != 0) {
            personId = dbperson.getPersonId();
         }
        else {
            System.out.println("Failed to get a person id");
        }
        return personId;
    }
    
    private void queryPerson(int personId) throws SQLException, ClassNotFoundException {
        DBPerson dbperson = new DBPerson();
        dbperson.queryPerson(personId);
        this.personId = dbperson.getPersonId();
        this.lastName = dbperson.getLastName();
        this.firstName = dbperson.getFirstName();
        this.middleName = dbperson.getMiddleName();
        this.birthDate = dbperson.getBirthDate();
        this.gender = dbperson.getGender();
        this.prefixTitle = dbperson.getPrefixTitle();
        this.suffix = dbperson.getSuffix();
        this.address1 = dbperson.getAddress1();
        this.address2 = dbperson.getAddress2();
        this.city = dbperson.getCity();
        this.country = dbperson.getCountry();
        this.state = dbperson.getState();
        this.postalCode = dbperson.getPostalCode();
        this.emailAddress = dbperson.getEmailAddress();
        this.phone1 = dbperson.getPhone1();
    }
    
    public int updatePerson() {
        return 0;
    }
    
    // Getters and Setters
    public int getPersonId() {
	return personId;
    }
    public void setPersonId(int personId) {
	this.personId = personId;
    } 
    
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
