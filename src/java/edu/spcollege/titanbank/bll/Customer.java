package edu.spcollege.titanbank.bll;

public class Customer {
    private String customerId = "1234";
    private String firstName = "Rick";
    private String lastName = "Meijer";
    private String middleName = "Steven";
	
    // Note: The customer id is stored with the userid
    public Customer(String id) {
            this.customerId = id;
            queryCustomer(this.customerId);
    }

    private void queryCustomer(String id) {
        // Service to query the customer
    }

    public String getFirstName() {
		return firstName;
	}

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getMiddleName() {
	return middleName;
    }

    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }
    
}
