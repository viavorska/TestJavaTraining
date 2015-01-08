package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	  @Test
	  public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    
	    //save old state
	    List<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    //actions	
	    app.getContactHelper().initContactCreation();
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
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToContactsPage();
	    
	    //save new state
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    //compare states
	    //проверку размера списка можно убрать, так как у нас есть проверка объектов списка 
	    assertEquals(newContactList.size(), oldContactList.size() + 1);
	    
	    oldContactList.add(contact);
	    Collections.sort(oldContactList);
	    assertEquals(newContactList, oldContactList);
	  }
	  
	  @Test
	  public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactCreation();
	    ContactData contact = new ContactData();
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToContactsPage();
	  }

}
