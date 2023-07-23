package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(name = "firstname")
		WebElement txtFirstname;

		@FindBy(name = "lastname")
		WebElement txtLasttname;

		@FindBy(name = "email")
		WebElement txtEmail;

		

		@FindBy(name = "password")
		WebElement txtPassword;

		

		@FindBy(xpath = "//body/main/div/div/div/form/div/div/div[1]//input")
		WebElement chkdPolicy;

		@FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
		WebElement btnContinue;
		
		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		

		public void setPrivacyPolicy() {
			
			chkdPolicy.sendKeys(Keys.RETURN);

		}
public void clickContinue() {
			//sol1 
			//btnContinue.click();
			
			//sol2 
			btnContinue.submit();
			
			//sol3
			//Actions act=new Actions(driver);
			//act.moveToElement(btnContinue).click().perform();
						
			//sol4
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", btnContinue);
			
			//Sol 5
			//btnContinue.sendKeys(Keys.RETURN);
			
			//Sol6  
			//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        //mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			
		

		}
}
