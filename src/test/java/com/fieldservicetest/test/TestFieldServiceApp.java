package com.fieldservicetest.test;

import org.testng.annotations.Test;

import com.fieldservicetest.pages.AccessPopupTestPage;
import com.fieldservicetest.pages.HomeTestPage;
import com.fieldservicetest.pages.LoginTestPage;
import com.fieldservicetest.pages.ServiceDetailsTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class TestFieldServiceApp extends WebDriverTestCase {

	@Test
	public void testfieldSerice()
	{ 
		LoginTestPage testpage= new LoginTestPage();
		/*testpage.uninstallApp();
		testpage.installApp();
		testpage.launchApp();*/
		testpage.loginToFieldSeriveApp("test@test.com","test");
		AccessPopupTestPage access= new AccessPopupTestPage();
		//access.selectAllow();
		HomeTestPage home= new HomeTestPage();
		home.verifyHomePage();
		home.selectService("0");
		ServiceDetailsTestPage detailPage= new ServiceDetailsTestPage();
		/*detailPage.swipeUp();*/
		detailPage.verifyServiceSelection();
		
		
			
	}

	
}
