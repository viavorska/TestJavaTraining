package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	  @Test
	  public void testContactRemoval() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactModification();
	    app.getContactHelper().submitContactRemoval();
	    app.getContactHelper().returnToContactsPage();
	  }

}
