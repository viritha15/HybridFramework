package com.gcr.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class TC2 extends StartBrowser{
	@Test
	public void Login_LogoutTestCaseExcel() throws Exception {
		CommonFunctions cfs = new CommonFunctions();
		ActionDriver ad = new ActionDriver();
		Fillo f = new Fillo();
		Connection con = f.getConnection("TestData/Data.xlsx");
		String query = "select * from SauceLogin";
		Recordset rs =con.executeQuery(query);
		while (rs.next()) {
			cfs.login(rs.getField("UserName"), rs.getField("Password"));
		}
		//assertions always in test case
		String actualTitle= ad.getTitle();
		String expTitle="Swag Labs";
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
