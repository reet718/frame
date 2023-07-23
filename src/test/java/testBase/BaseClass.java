package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public WebDriver driver;
public Logger logger;
public ResourceBundle rb;
@BeforeClass
@Parameters("browser")
public void setup(String br)


{
	logger = LogManager.getLogger(this.getClass());
	rb=ResourceBundle.getBundle("config");
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	if (br.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver(option);
	}
	else if (br.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	driver.get("https://demo.opencart.com/index.php");   // remote App URL
	driver.manage().window().maximize();
}

@AfterClass
public void tearDown()
{
	driver.close();
}
public String randomeString()
{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
}

public String randomeNumber()
{
	String generatedString=RandomStringUtils.randomNumeric(10);
	return generatedString;
}

public String randomAlphaNumeric()
{
	String str=RandomStringUtils.randomAlphabetic(3);
	String num=RandomStringUtils.randomNumeric(3);
	
	return (str+"@"+num);
}
public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	
	
	FileUtils.copyFile(source, new File(destination));
	
	return destination;

}
}