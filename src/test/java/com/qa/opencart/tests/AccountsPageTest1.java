package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.ResultsPage1;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class AccountsPageTest1 extends BaseTest{
	
	@BeforeClass
	public void accPageSetUp() {
		
		accountsPage1=loginPage1.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	@Test(priority=1)
	public void accPageTitleTest() {
		String title = accountsPage1.getAccPageTitle();
		System.out.println("acc page title is: " + title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	@Test(priority=2)
	public void accPageHeaderTest() {
		String header = accountsPage1.getAccountPageHeader();
		System.out.println("acc page header is: " + header);
		Assert.assertEquals(header, Constants.PAGE_HEADER);
	}
	@Test(priority=3)
	public void accPageList() {
		
		List<String> AccSecList = accountsPage1.getAccountssectionList();
		System.out.println("Accounts List"+AccSecList);
		Assert.assertEquals(AccSecList, Constants.EXPECTED_ACC_SEC_LIST);
	}
	
	@Test(priority = 4)
	public void logoutLinkExistTest() {
		Assert.assertTrue(accountsPage1.isLogoutLinkExist());
	}
	
	@DataProvider
	public Object[][] getSearchData() {
		
		
		return new Object[][] {
			{"Macbook Pro"},
			{"Macbook Air"},
			{"Apple"}
		};

	}
	@Test(priority = 5, dataProvider = "getSearchData")
	public void searchTest(String ProductName) {
		
		resultsPage1=accountsPage1.doSearch(ProductName);
		
	}
	
	
	@DataProvider
	public Object[][] getProductSelectData() {
		return ExcelUtil.getTestData(Constants.PRODUCT_SHEET_NAME);
		
	}
	
	
	@Test(priority = 6, dataProvider = "getProductSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		
		
		resultsPage1=accountsPage1.doSearch(productName);
		resultsPage1.selectProduct(mainProductName);
		
		
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	


