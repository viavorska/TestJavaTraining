package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	  @Test
	  public void testContactModification() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactModification();
	    ContactData contact = new ContactData();
	    contact.lastName = "Бирюгина";
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToContactsPage();
	  }

}
