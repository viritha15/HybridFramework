package com.gcr.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.or.WebShopHomePage;
import com.gcr.reuse.BusinessFunction;

public class TC5 extends StartBrowser {
  @Test
  public void LoginLogout_WebShop() throws Exception {
	  BusinessFunction bfs = new BusinessFunction();
	  ActionDriver ad = new ActionDriver();
	  Fillo f = new Fillo();
	  Connection con = f.getConnection("TestData/Data.xlsx");
	  String query = "select * from webshop";
	  Recordset rs = con.executeQuery(query);
	  while (rs.next()) {
		  bfs.loginWebShop(rs.getField("UserName"), rs.getField("PassWord"));
	  }
	  String actualText = ad.getText(WebShopHomePage.lnklogout,"Logout link");
	  String expText="Log out";
	  //StartBrowser.childTest = StartBrowser.parentTest.creatTest.createNode("Verify Title");
	  try {
		  Assert.assertEquals(actualText, expText);
		  StartBrowser.childTest.pass("Login verification Successful");
	  } catch (AssertionError e) {
		  StartBrowser.childTest.fail("Verification faild:" + "Actual Tect :" +actualText + "Expected Text is " +expText);
		  throw e;
	  }
	//  Thread.sleep(1000);
	  bfs.logoutWebShop();
  }
}
