package com.gcr.scripts;

import org.testng.annotations.Test;

import com.gcr.config.StartBrowser;
import com.gcr.reuse.BusinessFunction;

public class TC4 extends StartBrowser {
  @Test
  public void LoginLogout_WebShop() throws Exception {
	  BusinessFunction bfs = new BusinessFunction();
	  bfs.loginWebShop();
	  Thread.sleep(2000);
	  
  }
}
