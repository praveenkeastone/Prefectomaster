package com.fieldservicetest.pages;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.thoughtworks.selenium.webdriven.commands.GetBodyText;

public class LoginTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "passwdtxtbox.loginpage.fieldservice")
	private QAFWebElement passwdtxtboxLoginpageFieldservice;
	@FindBy(locator = "emailtxtbox.loginpage.fieldservice")
	private QAFWebElement emailtxtboxLoginpageFieldservice;
	@FindBy(locator = "signinbtn.loginpage.fieldservice")
	private QAFWebElement signinbtnLoginpageFieldservice;

	public LoginTestPage() {
		new WebDriverTestBase().getDriver();
		
	}
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getPasswdtxtboxLoginpageFieldservice() {
		return passwdtxtboxLoginpageFieldservice;
	}

	public QAFWebElement getEmailtxtboxLoginpageFieldservice() {
		return emailtxtboxLoginpageFieldservice;
	}

	public QAFWebElement getSigninbtnLoginpageFieldservice() {
		return signinbtnLoginpageFieldservice;
	}
	
	public void uninstallApp()
	{
		Map<String, Object> params = new HashMap<>();
		   
		params.put("identifier", "com.infostretch.sourceapp");
		 driver.executeScript("mobile:application:uninstall", params);
	}
	public void installApp()
	{
		Map<String, Object> params = new HashMap<>();
		  
		params.put("file", ConfigurationManager.getBundle().getPropertyValue("driver.capabilities.appPath"));
		params.put("instrument", "noinstrument");
		driver.executeScript("mobile:application:install", params); 
	}
	public void launchApp()
	{
		Map<String, Object> params = new HashMap<>();
		params.put("package", "com.infostretch.sourceapp");
		params.put("activity", "com.infostretch.sourceapp.LoginActivity");
		driver.executeScript("mobile:activity:open", params);
	}
	
	
	public void loginToFieldSeriveApp(String userEmail,String userPassword)
	{
		emailtxtboxLoginpageFieldservice.sendKeys(userEmail);
		passwdtxtboxLoginpageFieldservice.sendKeys(userPassword);
		signinbtnLoginpageFieldservice.click();
	}

}
