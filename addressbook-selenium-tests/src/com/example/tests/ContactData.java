package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email1;
	public String email2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String secondaryAddress;
	public String secondaryPhone;

	public ContactData() {
	}
	
	public ContactData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email1, String email2, String bDay, String bMonth,
			String bYear, String secondaryAddress, String secondaryPhone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email1 = email1;
		this.email2 = email2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.secondaryAddress = secondaryAddress;
		this.secondaryPhone = secondaryPhone;
	}
}