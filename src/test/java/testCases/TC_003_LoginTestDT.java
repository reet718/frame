package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginTestDT extends BaseClass{
	
	
	
@Test(dataProvider="Testdata")
public void test_account_login(String email,String password, String exp) {
	
	logger.info("TC_002_LoginTest has started");
	
	driver.get(rb.getString("url"));
	logger.info("Home Page Displayed ");
	
	driver.manage().window().maximize();
	
HomePage homepage=new HomePage(driver);
LoginPage loginpage=new LoginPage(driver);
MyAccountPage myaccpage=new MyAccountPage(driver);

try {
homepage.clickMyAccount();
homepage.clickLogin();
loginpage.enteremail(email);
loginpage.enterpassword(password);
loginpage.clickLogin();

boolean val=loginpage.confirmlogin();

if(exp.equals("Valid")) {
	
if(val==true) {
	Assert.assertTrue(true);
	logger.info("Login Passed");
	
	myaccpage.clickLogout();
}else {
	Assert.fail();
	logger.error("Login Failed");
}
}

else if(exp.equals("Invalid")) {
	if(val==true) {
		myaccpage.clickLogout();
		Assert.fail();
		
	}else {
		Assert.assertTrue(true);
		logger.info("Login Failed");
	}
}
	

}

catch(Exception e) {
	Assert.fail();
	logger.fatal("LoginTest Failed");
	e.getMessage();
}
}


@DataProvider(name="Testdata")
public String[][] XLData() throws IOException{
	
	String path=".\\testData\\Opencart_LoginData.xlsx";
	XLUtility xl=new XLUtility(path);
	int rowcount=xl.getRowCount("Sheet1");
	int colcount=xl.getCellCount("Sheet1", 1);
	int i, j;
	String[][] logindata=new String[rowcount][colcount];
	
	for(i=1;i<=rowcount;i++) {
		for(j=0;j<colcount;j++) {
			
			logindata[i-1][j]=xl.getCellData("Sheet1", i, j);
		}
	}
	
	return logindata;
	
	
}
}