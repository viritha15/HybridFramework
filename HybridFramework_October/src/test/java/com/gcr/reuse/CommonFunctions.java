package com.gcr.reuse;

import org.openqa.selenium.WebDriver;

import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.or.HomePage;
import com.gcr.or.LoginPage;

public class CommonFunctions {
	
	public WebDriver driver;
	public ActionDriver ad;
	
	public CommonFunctions()
	{
		driver = StartBrowser.driver;
		ad = new ActionDriver();
	}

	public void login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to SauceDemo application");
		ad.navigateToApplication("https://www.saucedemo.com/");
		ad.type(LoginPage.txtuserName, "standard_user", "UserName textbox");
		ad.type(LoginPage.txtPassword, "secret_sauce", "Password textbox");
		ad.click(LoginPage.btnLogin, "Login Button");
	}
	
	public void login(String userName, String password) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to SauceDemo application using Excel");
		ad.navigateToApplication("https://www.saucedemo.com/");
		ad.type(LoginPage.txtuserName, userName, "UserName textbox");
		ad.type(LoginPage.txtPassword, password, "Password textbox");
		ad.click(LoginPage.btnLogin, "Login Button");
	}
	
	public void logout() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout of SauceDemo application");
		ad.click(HomePage.menu, "Menu");
		ad.click(HomePage.lnkLogout, "Logout link");
	}
}
