package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage1 {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By accsections=By.xpath("//div[@id='content']//h2");
	private By header=By.xpath("//div[@id='logo']//h1//a");
	private By logout=By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']");
	private By searchtext=By.xpath("//input[@placeholder='Search']");
	private By searchButton=By.xpath("//button[@class='btn btn-default btn-lg']");
	private By logoutLink = By.linkText("Logout");
	
	
	public String getAccPageTitle() {
		return elementUtil.waitForTitleIs(Constants.ACCOUNT_PAGE_TITLE, 5);
	}

	
	public String getAccPageURL() {
		return elementUtil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL_FRACTION, 5);
	}
	
	public List<String> getAccountssectionList() {
		
		List<String> accSecValueList = new ArrayList<String>();
		List<WebElement> accsecList = elementUtil.getElements(accsections);
		for (WebElement e: accsecList) {
			accSecValueList.add(e.getText());
		}
		return accSecValueList;
	}
	
	public ResultsPage1 doSearch(String productname) {
		System.out.println("searching the product: " + productname);
		
		elementUtil.doSendKeys(searchtext, productname);
		elementUtil.doClick(searchButton);
		
		return new ResultsPage1(driver);
	}
	
	
	
	public String getAccountPageHeader() {
		return elementUtil.doGetText(header);
	}

	public AccountsPage1(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	
	public boolean isLogoutLinkExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}

}
