package com.fieldservicetest.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ServiceListComp  extends QAFWebComponent{
	
	public ServiceListComp(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "servicename.homepage.fieldservice")
	private QAFWebElement servicenameHomepageFieldservice;
	@FindBy(locator = "locationmiles.homepage.fieldservice")
	private QAFWebElement locationmilesHomepageFieldservice;
	
	public QAFWebElement getServicenameHomepageFieldservice() {
		return servicenameHomepageFieldservice;
	}

	public QAFWebElement getLocationmilesHomepageFieldservice() {
		return locationmilesHomepageFieldservice;
	}

}
