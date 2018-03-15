package com.fieldservicetest.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.fieldservicetest.bean.ServiceBean;
import com.fieldservicetest.component.ServiceListComp;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
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

	
	@QAFTestStep(description = "user should see the list of services")
	
	public void verifyHomePage()
	{
		getServicelistHomepageFieldservice().get(0).waitForVisible();	
		Validator.verifyThat(getServicelistHomepageFieldservice().get(0).getServiceCategoryHomepageFieldservice().isPresent()
				&&getServicelistHomepageFieldservice().get(0).getServiceCategoryHomepageFieldservice().isDisplayed(), 
				Matchers.equalTo(true));
		
		for(ServiceListComp comp: getServicelistHomepageFieldservice())
		{
			Reporter.log(comp.getLocationmilesHomepageFieldservice().getText(),true);
			Reporter.log(comp.getServiceCategoryHomepageFieldservice().getText(),true);
			//Reporter.log(comp.getServicenameHomepageFieldservice().getText(),true);
		}
		
	}
	
	@QAFTestStep(description = "user selects service {0} from service list")
	public void selectService(String str0)
	{	
		ServiceBean bean = new ServiceBean();
		getServicelistHomepageFieldservice().get(0).waitForVisible();
		bean.setCategoryName(getServicelistHomepageFieldservice().get(Integer.parseInt(str0)).getServiceCategoryHomepageFieldservice().getText());
		getServicelistHomepageFieldservice().get(Integer.parseInt(str0)).getServiceCategoryHomepageFieldservice().click();
		ConfigurationManager.getBundle().setProperty("bean.data", bean);
	}
	
	@QAFTestStep(description = "user is already loggedin logout first")
	public void verifyLogoutPresent()
	{
		if(logoutbtnHomepageFieldservice.isPresent())
		{
			logoutbtnHomepageFieldservice.click();
		}
		else
		{
			Reporter.log("user is on the Logout page");
		}
	}
	
	
	@QAFTestStep(description = "user should see Map {0}")
	
	public void verifyMap(String fileName)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("content", "PUBLIC:/Praveendm/"+fileName);
		params.put("context", "body");
		String res = (String) driver.executeScript("mobile:image:find",params);
		Reporter.log(")))))))))))))))))))))(((((((((((((((((((((     "+ res, true);
		Validator.verifyThat(res, Matchers.containsString("true"));
	}

}
