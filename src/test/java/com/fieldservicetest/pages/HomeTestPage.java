package com.fieldservicetest.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.fieldservicetest.component.ServiceListComp;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class HomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "servicelist.homepage.fieldservice")
	private List<ServiceListComp> servicelistHomepageFieldservice;
	@FindBy(locator = "logoutbtn.homepage.fieldservice")
	private QAFWebElement logoutbtnHomepageFieldservice;
	
@Override
public void launchPage(PageLocator locator, Object... args) {
	
}
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<ServiceListComp> getServicelistHomepageFieldservice() {
		return servicelistHomepageFieldservice;
	}

	public QAFWebElement getLogoutbtnHomepageFieldservice() {
		return logoutbtnHomepageFieldservice;
	}

	
	
	
	public void verifyHomePage()
	{
		
		logoutbtnHomepageFieldservice.waitForPresent();
		Validator.verifyThat(logoutbtnHomepageFieldservice.isPresent()&&logoutbtnHomepageFieldservice.isDisplayed(), 
				Matchers.equalTo(true));
		
		
	
		
	}
	public void selectService(int index)
	{
		getServicelistHomepageFieldservice().get(0).waitForVisible();
		
		getServicelistHomepageFieldservice().get(index).getServicenameHomepageFieldservice().click();
	}

}
