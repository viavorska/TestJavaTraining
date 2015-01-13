package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deletesomeGroup() throws Exception{
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupsPage();
	    
	    //save old state
	    List<GroupData> oldGroupList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldGroupList.size()-1);
	    
	    //actions	
	    app.getGroupHelper().deleteGroup(index);
	    app.getGroupHelper().returnToGroupsPage();	
	    
	    //save new state
	    List<GroupData> newGroupList = app.getGroupHelper().getGroups();
	    
	    //compare states
	    oldGroupList.remove(index);
	    Collections.sort(newGroupList);
	    Collections.sort(oldGroupList);
	    assertEquals(newGroupList, oldGroupList);	
	}

}
