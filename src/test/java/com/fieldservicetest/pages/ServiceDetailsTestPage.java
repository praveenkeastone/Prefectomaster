package com.fieldservicetest.pages;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;

import com.fieldservicetest.bean.ServiceBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
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
	
	
	public void swipe()
	{
		
	}
	
	@QAFTestStep(description = "user should see the selected service detail page")
	
	public void verifyServiceSelection()
	{
		servicecategoryDetailpageFieldservice.waitForPresent();
		ServiceBean data = (ServiceBean)ConfigurationManager.getBundle().getProperty("bean.data");
		Validator.verifyThat(servicecategoryDetailpageFieldservice.isDisplayed()&&servicecategoryDetailpageFieldservice.isPresent(), Matchers.equalTo(true));
		Validator.verifyThat(data.getCategoryName(), Matchers.containsString(servicecategoryDetailpageFieldservice.getText()));

	}

}
