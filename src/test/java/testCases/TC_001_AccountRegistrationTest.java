package testCases;

import testBase.BaseClass;
import pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test
	public void test_account_Registration() {
		logger.info("testCasestarting");
		logger.trace("this is trace");
		try
		
		{
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			captureScreen("homepage");
			hp.clickRegister();
			captureScreen("registerpage");
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
			
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			
			
			regpage.setPrivacyPolicy();
			
			
			regpage.clickContinue();
		}
		
		catch (Exception e) {
			Assert.fail();
		}
			
		logger.info("testCasestarting");
			
			
		}
}
