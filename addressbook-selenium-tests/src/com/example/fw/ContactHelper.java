package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToContactsPage() {
		click(By.linkText("home page"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}
	
	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homePhone);
		type(By.name("mobile"), contact.mobilePhone);
		type(By.name("work"), contact.workPhone);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
		type(By.name("byear"), contact.bYear);
		type(By.name("address2"), contact.secondaryAddress);
	    select(By.name("bday"), contact.bDay);
	    select(By.name("bmonth"), contact.bMonth);
	    type(By.name("phone2"), contact.secondaryPhone);
	}

}
