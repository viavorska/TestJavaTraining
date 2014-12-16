package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	  @Test
	  public void testNonEmptyContactCreation() throws Exception {
		app.navigationHelper.openMainPage();
	    app.contactHelper.initContactCreation();
	    ContactData contact = new ContactData();
	    contact.firstName = "first name 1";
	    contact.lastName = "last name 1";
	    contact.address = "address 1";
	    contact.homePhone = "543254325432";
	    contact.mobilePhone = "675365365436";
	    contact.workPhone = "4234231432";
	    contact.email1 = "432432@gmail.com";
	    contact.email2 = "312312@gmail.com";
	    contact.bDay = "3";
	    contact.bMonth = "April";
	    contact.bYear = "1985";
	    contact.secondaryAddress = "http://dkfjhdsajk.com";
	    contact.secondaryPhone = "+7(321)098789732";
	    app.contactHelper.fillContactForm(contact);
	    app.contactHelper.submitContactCreation();
	    app.contactHelper.returnToContactsPage();
	  }
	  
	  @Test
	  public void testEmptyContactCreation() throws Exception {
		app.navigationHelper.openMainPage();
	    app.contactHelper.initContactCreation();
	    ContactData contact = new ContactData();
	    app.contactHelper.fillContactForm(contact);
	    app.contactHelper.submitContactCreation();
	    app.contactHelper.returnToContactsPage();
	  }

}
