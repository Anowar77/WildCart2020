package com.qa.wildcart.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.wildcart.base.BasePage;
import com.qa.wildcart.pages.LoginPage;

public class LoginPageTest extends BasePage {
	
	//TestNg -- unit testing framework use with java and junit also
	//preconditions .... testcase(step) .... assertion.....close test
	//@Beforetest......@Test.....Assertions.....close the browser
	//launch browser..,url,...title....verify....close the browser
     WebDriver driver;
     BasePage basepage;
     LoginPage loginpage;
     

	
	@BeforeTest
	public void setup() {
		basepage=new BasePage();
		driver=basepage.initl_driver("chrome");
		loginpage=new LoginPage(driver);
		
	}
	
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		
		Assert.assertEquals(loginpage.isSignUpButtonExists(),true);
		
	}
	
	@Test(priority=2)
	public void verifyPageTitle() {
		String title=loginpage.getLoginPageTitle();
		System.out.println("Title is "+title);
		Assert.assertEquals(title,"WildFire Cart");
		
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginpage.doLogin("user","pass");
		
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
}
