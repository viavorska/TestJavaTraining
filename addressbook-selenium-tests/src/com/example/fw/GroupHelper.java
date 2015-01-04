package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
	    List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
	    for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.groupName = title.substring("Select(".length(), title.length() - ")".length()); 
			groups.add(group) ;			
		}
		return groups;
	}

}
