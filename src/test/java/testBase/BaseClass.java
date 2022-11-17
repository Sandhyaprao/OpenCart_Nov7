package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Logger logger;
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		ChromeOptions options =new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/index.php");
		driver.manage().window().maximize();
		logger =LogManager.getLogger(this.getClass());
	}
	
	public String randomeString() {
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return(generatedString);
	}
	public String randomeNumber() {
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return (generatedString2);
		
	}
	public String randomAlphanumaric() {
		String st=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return(st+"@"+num);
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{   Thread.sleep(6000);
		driver.quit();
	}
}
