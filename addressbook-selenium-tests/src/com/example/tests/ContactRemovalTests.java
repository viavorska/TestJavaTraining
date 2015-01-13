package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	  @Test
	  public void testContactRemoval() throws Exception {
		app.getNavigationHelper().openMainPage();
	    
	    //save old state
	    List<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    //actions	
	    app.getContactHelper().initContactModification();
	    app.getContactHelper().submitContactRemoval();
	    app.getContactHelper().returnToContactsPage();
	    
	    //save new state
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    //compare states
	    
	    oldContactList.remove(0);
	    Collections.sort(newContactList);
	    Collections.sort(oldContactList);
	    assertEquals(newContactList, oldContactList);
	  }

}
