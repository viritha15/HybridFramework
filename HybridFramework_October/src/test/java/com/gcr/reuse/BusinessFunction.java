package com.gcr.reuse;

import org.openqa.selenium.WebDriver;

import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.or.WebShopHomePage;
import com.gcr.or.WebShopLoginPage;

public class BusinessFunction {

	public WebDriver driver;
	public ActionDriver ad;
	
	public BusinessFunction()
	{
		driver = StartBrowser.driver;
		ad = new ActionDriver();
	}
	
	public void loginWebShop() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to WebShop application");
		ad.navigateToApplication("https://demowebshop.tricentis.com/login");
		ad.click(WebShopHomePage.lnklogin, "Login Link");
		ad.type(WebShopLoginPage.txtemail, "Viritha.qatech@gmail.com", "Email Text box");
		ad.type(WebShopLoginPage.txtPassword, "Virith@16", "Password Textbox");
		ad.click(WebShopLoginPage.btnLogin, "Login Button");
		
	}
	public void loginWebShop(String userName, String passWord) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to WebShop application using arguments");
		ad.navigateToApplication("https://demowebshop.tricentis.com/login");
		ad.click(WebShopHomePage.lnklogin, "Login Link");
		ad.type(WebShopLoginPage.txtemail, userName, "Email Text box");
		ad.type(WebShopLoginPage.txtPassword, passWord, "Password Textbox");
		ad.click(WebShopLoginPage.btnLogin, "Login Button");
		
	}
	
	public void logoutWebShop() throws Exception 
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout from WebShop application");
		ad.click(WebShopHomePage.lnklogout, "Logout Link");
	}
}
