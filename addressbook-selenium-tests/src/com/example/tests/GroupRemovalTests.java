package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deletesomeGroup() {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupsPage();
	    
	    //save old state
	    List<GroupData> oldGroupList = app.getGroupHelper().getGroups();
	    
	    //actions	
	    app.getGroupHelper().deleteGroup(0);
	    app.getGroupHelper().returnToGroupsPage();	
	    
	    //save new state
	    List<GroupData> newGroupList = app.getGroupHelper().getGroups();
	    
	    //compare states
	    oldGroupList.remove(0);
	    Collections.sort(oldGroupList);
	    assertEquals(newGroupList, oldGroupList);	
	}

}
