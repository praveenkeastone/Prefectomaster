package com.fieldservicetest.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LoginTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "passwdtxtbox.loginpage.fieldservice")
	private QAFWebElement passwdtxtboxLoginpageFieldservice;
	@FindBy(locator = "emailtxtbox.loginpage.fieldservice")
	private QAFWebElement emailtxtboxLoginpageFieldservice;
	@FindBy(locator = "signinbtn.loginpage.fieldservice")
	private QAFWebElement signinbtnLoginpageFieldservice;

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
	
	public void loginToFieldSeriveApp(String userEmail,String userPassword)
	{
		emailtxtboxLoginpageFieldservice.sendKeys(userEmail);
		passwdtxtboxLoginpageFieldservice.sendKeys(userPassword);
		signinbtnLoginpageFieldservice.click();
		
		
	}

}
