package com.fieldservicetest.test;

import org.testng.annotations.Test;

import com.fieldservicetest.pages.AccesspopupTestPage;
import com.fieldservicetest.pages.HomeTestPage;
import com.fieldservicetest.pages.LoginTestPage;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class TestFieldServiceApp extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void testfieldSerice()
	{
		driver.get("/");
		LoginTestPage testpage= new LoginTestPage();
		testpage.loginToFieldSeriveApp("test@test.com","test");
		AccesspopupTestPage access= new AccesspopupTestPage();
		access.selectAllow();
		HomeTestPage home= new HomeTestPage();
		home.verifyHomePage();
		
			
	}

}
