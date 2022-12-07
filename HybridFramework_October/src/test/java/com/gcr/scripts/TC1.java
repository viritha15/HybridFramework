package com.gcr.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class TC1 extends StartBrowser{
  @Test
  public void Login_LogoutTestCase() throws Exception {
	  CommonFunctions cfs = new CommonFunctions();
	  ActionDriver ad = new ActionDriver();
	  cfs.login();
	  //assertions always in test case
	 String actualTitle= ad.getTitle();
	 String expTitle="Swag Labs 123";
	 //StartBrowser.childTest = StartBrowser.parentTest.createNode("Verify Title");
	 try {
		 Assert.assertEquals(actualTitle, expTitle);
		 StartBrowser.childTest.pass("Title verification Successful");
	} catch (AssertionError e) {
		StartBrowser.childTest.fail("Title verification Not Successful");
		throw e;
	}
	  cfs.logout();
  }
}
