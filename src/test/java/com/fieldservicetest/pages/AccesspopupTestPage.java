package com.fieldservicetest.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AccesspopupTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

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
		allowbtnLocationpopupFieldservice.click();
	}

}
