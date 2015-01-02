package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void fillGroupForm(GroupData groupData) {
		type(By.name("group_name"), groupData.groupName);
		type(By.name("group_header"), groupData.groupHeader);
		type(By.name("group_footer"), groupData.groupFooter);
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void deleteGroup(int index) {
		selectGroupByGroupIndex(index);
		click(By.name("delete"));
	}

	public void initGroupModification(int index) {
		selectGroupByGroupIndex(index);
		click(By.name("edit"));
		
	}
	
	public void selectGroupByGroupIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
		
	}

}
