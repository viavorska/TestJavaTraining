package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().goToGroupsPage();
    
    //save old state
    List<GroupData> oldGroupList = app.getGroupHelper().getGroups();
    
    //actions	
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "group name 1";
    group.groupHeader = "group header 1";
    group.groupFooter = "group footer 1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    //save new state
    List<GroupData> newGroupList = app.getGroupHelper().getGroups();
    
    //compare states
    assertEquals(newGroupList.size(), oldGroupList.size() + 1);
    
    oldGroupList.add(group);
    assertEquals(newGroupList, oldGroupList);
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }     
}
