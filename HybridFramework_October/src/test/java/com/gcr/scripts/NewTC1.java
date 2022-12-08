package com.gcr.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class NewTC1 extends StartBrowser{
  @Test
  public void OnlyLoginLogout() throws Exception {
	  CommonFunctions cfs = new CommonFunctions();
	  cfs.login();
	  cfs.logout();
	  //This is the test case for NewTC1
  }
}
