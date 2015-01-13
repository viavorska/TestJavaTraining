package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;


@Test
  public void f() {
  }

@BeforeTest
public void setUp() throws Exception {
	app = new ApplicationManager();
  }

@AfterTest
public void tearDown() throws Exception {
	app.stop();
    }

@DataProvider
public Iterator<Object[]> randomValidGroupGenerator(){
	List<Object[]> list = new ArrayList<Object[]>();
	for(int i = 0; i < 4; i++){
		GroupData group = new GroupData();
		group.groupName = generateRandomString();
		group.groupHeader = generateRandomString();
		group.groupFooter = generateRandomString();
		list.add(new Object[]{group});
	}		
	return list.iterator();
	}

@DataProvider
public Iterator<Object[]> randomValidContactGenerator(){
	List<Object[]> list = new ArrayList<Object[]>();
	for(int i = 0; i < 2; i++){
		Random rnd = new Random();
		ContactData contact = new ContactData();
		contact.firstName = generateRandomString();
		contact.lastName = generateRandomString();
	    contact.address = generateRandomString();
	    contact.homePhone = generateRandomString();
	    contact.mobilePhone = generateRandomString();
	    contact.workPhone = generateRandomString();
	    contact.email1 = generateRandomString();
	    contact.email2 = generateRandomString();
	    contact.bDay = "" + rnd.nextInt(31);
	    //ѕока не научилась правильно использовать toString :(
	    contact.bMonth = "April";
	    contact.bYear = "" + rnd.nextInt(2015);
	    contact.secondaryAddress = generateRandomString();
	    contact.secondaryPhone = generateRandomString();
		list.add(new Object[]{contact});
	}		
	return list.iterator();
	}

	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
		return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}
	
}
