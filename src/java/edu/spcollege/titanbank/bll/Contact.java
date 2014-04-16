package edu.spcollege.titanbank.bll;

public class Contact {
    String id = "";
	String phoneNumber = "";
    String mobileNumber = "";
    String otherNumber = "";
    String email = "";
    
	
    public Contact(String id, String phoneNumber, String mobileNumber,
			String otherNumber, String email) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherNumber = otherNumber;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtherNumber() {
		return otherNumber;
	}
	public void setOtherNumber(String otherNumber) {
		this.otherNumber = otherNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
