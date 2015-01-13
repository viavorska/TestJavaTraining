package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	  @Test(dataProvider = "randomValidContactGenerator")
	  public void testContactCreationWithValidData(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
	    
	    //save old state
	    List<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    //actions	
	    app.getContactHelper().initContactCreation();
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToContactsPage();
	    
	    //save new state
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    //compare states
	    //проверку размера списка можно убрать, так как у нас есть проверка объектов списка 
	    assertEquals(newContactList.size(), oldContactList.size() + 1);
	    
	    oldContactList.add(contact);
	    Collections.sort(newContactList);
	    Collections.sort(oldContactList);
	    assertEquals(newContactList, oldContactList);
	  }
	  
	  @Test
	  public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    
	    //save old state
	    List<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    //actions	
	    app.getContactHelper().initContactCreation();
	    ContactData contact = new ContactData();
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToContactsPage();
	    
	    //save new state
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    //compare states
	    
	    oldContactList.add(contact);
	    Collections.sort(newContactList);
	    Collections.sort(oldContactList);
	    assertEquals(newContactList, oldContactList);
	  }

}
