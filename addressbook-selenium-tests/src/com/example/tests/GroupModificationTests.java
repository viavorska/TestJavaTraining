package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup() {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupsPage();
	    
	    //save old state
	    List<GroupData> oldGroupList = app.getGroupHelper().getGroups();

	    //actions
	    app.getGroupHelper().initGroupModification(0);
	    GroupData group = new GroupData();
	    group.groupName = "new name";
		app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();	
	    
	    //save new state
	    List<GroupData> newGroupList = app.getGroupHelper().getGroups();
	    
	    //compare states
	    oldGroupList.remove(0);
	    oldGroupList.add(group);
	    Collections.sort(oldGroupList);
	    assertEquals(newGroupList, oldGroupList);		
	}
}
