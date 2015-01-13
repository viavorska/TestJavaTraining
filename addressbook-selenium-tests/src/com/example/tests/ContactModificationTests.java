package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	  @Test
	  public void testContactModification() throws Exception {
		app.getNavigationHelper().openMainPage();
	    
	    //save old state
	    List<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    //actions	
	    app.getContactHelper().initContactModification();
	    ContactData contact = new ContactData();
	    contact.lastName = "Бирюгина";
	    contact.firstName = "Алла";
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToContactsPage();
	    
	    //save new state
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    //compare states
	    
	    Collections.sort(newContactList);
	    oldContactList.remove(contact);
	    oldContactList.add(contact);	    
	    Collections.sort(oldContactList);
	    assertEquals(newContactList, oldContactList);
	  }

}
