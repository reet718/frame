package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
public LoginPage(WebDriver driver) {
		
		super(driver);
	}

  
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
  
  
  @FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
  
  @FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
  
  //Actions
  


public void enteremail(String email) {
	txtEmailAddress.sendKeys(email);
}

public void enterpassword(String password) {
	txtPassword.sendKeys(password);
}

public void clickLogin()
{
	btnLogin.click();
}

public boolean confirmlogin() {
	try {
		return(msgHeading.isDisplayed());
	
	}
	catch(Exception e) {
		return(false);
		
	}
}

}