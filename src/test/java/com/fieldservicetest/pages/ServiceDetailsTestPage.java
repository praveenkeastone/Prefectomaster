package com.fieldservicetest.pages;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ServiceDetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "servicename.detailpage.fieldservice")
	private QAFWebElement servicenameDetailpageFieldservice;
	@FindBy(locator = "servicecategory.detailpage.fieldservice")
	private QAFWebElement servicecategoryDetailpageFieldservice;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getServicenameDetailpageFieldservice() {
		return servicenameDetailpageFieldservice;
	}

	public QAFWebElement getServicecategoryDetailpageFieldservice() {
		return servicecategoryDetailpageFieldservice;
	}
	
	public void swipeUp()
	{
		Map<String, Object> params = new HashMap<>();
		params.put("start", "20%,40%");
		params.put("end", "15%,60%");
		params.put("duration", "3");
		Object res = driver.executeScript("mobile:touch:swipe", params);
	}
	
	public void verifyServiceSelection()
	{
		Validator.verifyThat(servicecategoryDetailpageFieldservice.isDisplayed()&&servicecategoryDetailpageFieldservice.isPresent(), Matchers.equalTo(true));
	}

}
