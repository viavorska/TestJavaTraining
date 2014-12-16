package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
}
