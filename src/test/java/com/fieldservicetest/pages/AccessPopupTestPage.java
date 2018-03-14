package com.fieldservicetest.pages;

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
	
	public void selectAllow()
	{
		try {
		if(allowbtnLocationpopupFieldservice.isDisplayed()&&allowbtnLocationpopupFieldservice.isEnabled())
			allowbtnLocationpopupFieldservice.click();
		else
			System.out.println("allow button not visible");
		}
		catch(Exception e)
		{
			
		}
	}

}
