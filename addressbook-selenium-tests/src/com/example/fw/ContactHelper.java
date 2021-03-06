package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public void initContactModification(int index) {
		//driver.findElements(By.name("entry"))(index);
		//click(By.cssSelector("img[alt=\"Edit\"]"));s
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		//driver.findElements(By.name("entry"))(index).findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
	}

	public void submitContactModification() {
		click(By.name("update"));
	}
	
	public void submitContactRemoval() {
		driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();		  
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
	    List<WebElement> entries = driver.findElements(By.name("entry"));
	    for (WebElement entry : entries) {
	    	List<WebElement> cells = entry.findElements(By.tagName("td"));
	    	ContactData contact = new ContactData();
	    	contact.firstName = cells.get(2).getText();
			contacts.add(contact);		    						
		}
		return contacts;
	}

}
