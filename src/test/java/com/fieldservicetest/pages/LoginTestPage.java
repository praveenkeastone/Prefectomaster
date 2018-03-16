package com.fieldservicetest.pages;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
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
	
	@QAFTestStep(description = "user launches the application")
	public void launchdevice()
	{
		launchApp();	
	}
	
	
	@QAFTestStep(description = "user install the application")
	public void installApp()
	{
		Map<String, Object> params = new HashMap<>();
		  
		params.put("file", ConfigurationManager.getBundle().getPropertyValue("driver.capabilities.appPath"));
		params.put("instrument", "noinstrument");
		
		driver.executeScript("mobile:application:install", params); 
	}
	
	
	@QAFTestStep(description = "user should be able to launch application")
	public  void launchApp()
	{
		Map<String, Object> params = new HashMap<>();
		if(ConfigurationManager.getBundle().getProperty("platform.Name").equals("android"))
		{
		params.put("package", ConfigurationManager.getBundle().getProperty("driver.capabilities.appPackage"));
		params.put("activity", "com.infostretch.sourceapp.LoginActivity");
		driver.executeScript("mobile:activity:open", params);
		}
		else
		{
			params.put("identifier", ConfigurationManager.getBundle().getProperty("driver.capabilities.bundleId"));
			driver.executeScript("mobile:application:open", params);
		}
		
		
		
	}
	@QAFTestStep(description = "user uninstall the application")
	public void uninstallApp()
	{
		Map<String, Object> params = new HashMap<>();
		   
		params.put("identifier", "com.infostretch.sourceapp");
		driver.executeScript("mobile:application:uninstall", params);
	}
	@QAFTestStep(description = "user enters {0} and {1}and signIn")
	public void loginToFieldSeriveApp(String str0, String str1)
	{
		passwdtxtboxLoginpageFieldservice.click();
		passwdtxtboxLoginpageFieldservice.clear();
		passwdtxtboxLoginpageFieldservice.sendKeys(str1);
		emailtxtboxLoginpageFieldservice.click();
		emailtxtboxLoginpageFieldservice.clear();
		emailtxtboxLoginpageFieldservice.sendKeys(str0);
		
		signinbtnLoginpageFieldservice.click();
	}
	@QAFTestStep(description = "user should see the login page")
	public void verifyLoginScreen()
	{
		Validator.verifyThat(emailtxtboxLoginpageFieldservice.isPresent(), Matchers.equalTo(true));
		Validator.verifyThat(passwdtxtboxLoginpageFieldservice.isPresent(), Matchers.equalTo(true));
	}

}
