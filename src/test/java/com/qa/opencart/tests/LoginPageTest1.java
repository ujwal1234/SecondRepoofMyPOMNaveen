package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AccountsPage1;
import com.qa.opencart.pages.LoginPage1;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

public class LoginPageTest1 extends BaseTest{
	
	
	
	@Test(priority=1)
	public void LoginPageTitleTest1() {
		String title1 = loginPage1.getLoginPageTitle();
		System.out.println("LoginPage1 Title is "+title1);
		Assert.assertEquals(title1, Constants.LOGIN_PAGE_TITLE,Errors.TITLE_ERROR_MESSG);
		
	}
	@Test(priority=2)
	public void LoginPageHeaderTest1() {
		String header1 = loginPage1.getLoginPageHeader();
		System.out.println("LoginPage1 Header is"+header1);
		Assert.assertEquals(header1, Constants.PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void ForgetPasswordLinkTest() {
		
		Assert.assertTrue(loginPage1.isForgetPasswordLinkExist());
	}
	
	
	@Test(priority=4)
	public void LoginTest() {
		AccountsPage1 accountspage = loginPage1.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accountsPage1.isLogoutLinkExist());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}


