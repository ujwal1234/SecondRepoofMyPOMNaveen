package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage1 {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//private By locators
	
	private By emailid=By.id("input-email");
    private By password= By.id("input-password");
    private By LoginBTN= By.xpath("//input[@value='Login']");
    private By forgetpasswordLink=By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
    private By header=By.xpath("//div[@id='logo']//h1//a\r\n");
	private By registerlink=By.linkText("Register");
	
	
	public LoginPage1(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	
	// page actions/ page methods/ functionality/behavior of the page/ no assertion
	
	@Step("Get Login page Title")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public String getLoginPageHeader() {
		return elementUtil.doGetText(header);
	}
	
	public boolean isForgetPasswordLinkExist() {
		return elementUtil.doIsDisplayed(forgetpasswordLink);
	}
	
	
	public AccountsPage1 doLogin(String un,String pwd) {
		
		elementUtil.doSendKeys(emailid, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(LoginBTN);
		return new AccountsPage1(driver);
		
	}
	
	
	public RegistrationsPage1 navigateToRegistrationPage() {
		elementUtil.doClick(registerlink);
		return new RegistrationsPage1(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
