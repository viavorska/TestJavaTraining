package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage() {
		driver.get(manager.baseUrl);
	}

	public void goToGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}
}
