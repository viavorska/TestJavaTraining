package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	  @Test(dataProvider = "randomValidContactGenerator")
	  public void testContactModification(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
	    
	    //save old state
	    List<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldContactList.size()-1);
	    
	    //actions	
	    app.getContactHelper().initContactModification(index);
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToContactsPage();
	    
	    //save new state
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    //compare states
	    Collections.sort(newContactList);
	    oldContactList.remove(index);
	    oldContactList.add(contact);	    
	    Collections.sort(oldContactList);
	    assertEquals(newContactList, oldContactList);
	  }

}
