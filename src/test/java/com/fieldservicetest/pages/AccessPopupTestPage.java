package com.fieldservicetest.pages;

import org.testng.Reporter;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AccessPopupTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "allowbtn.locationpopup.fieldservice")
	private QAFWebElement allowbtnLocationpopupFieldservice;
	@FindBy(locator = "denybtn.locationpopup.fieldservice")
	private QAFWebElement denybtnLocationpopupFieldservice;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getAllowbtnLocationpopupFieldservice() {
		return allowbtnLocationpopupFieldservice;
	}

	public QAFWebElement getDenybtnLocationpopupFieldservice() {
		return denybtnLocationpopupFieldservice;
	}
	
	
	
	
	@QAFTestStep(description = "user should see location popup")
	public void selectAllow() throws InterruptedException
	{
		Thread.sleep(3000);
		
		if(allowbtnLocationpopupFieldservice.isPresent())
		{
			allowbtnLocationpopupFieldservice.click();
		}
		else
		{
			Reporter.log("allow button not visible", true);
		}
		
	}

}
