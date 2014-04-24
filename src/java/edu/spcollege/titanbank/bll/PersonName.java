/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

/**
 *
 * @author admin
 */
public class PersonName {
    private int customerId = 0;
    private int personId = 0;
    private String fullName = "";
    private java.util.Date birthDate = null;
    private String gender = "";

    public PersonName(int customerId, int personId, String lastName, String firstName, String middleName, 
                      String suffix, java.util.Date birthDate, String gender) {
        this.customerId = customerId;
        this.personId = personId;
        this.fullName = lastName + ", " + firstName + " " + middleName + " " + suffix;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    public int getPersonId() {
        return this.personId;
    }
    public String getFullName() {
        return this.fullName;
    }
    public java.util.Date getBirthDate() {
        return this.birthDate;
    }
    public String getGender() {
        return this.gender;
    }
}
