package commomCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Loginpage;

public class BaseCode {

    public WebDriver driver;	
    
    public Loginpage log ;
	
	public WebDriver launchBrowser() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GenralFile.properties");
		prop.load(file);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
//		prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless"))
		{
		option.addArguments("headless");
		}
	    driver = new ChromeDriver(option);
//	    driver.get("https://rahulshettyacademy.com/client/");
	    driver.manage().window().setSize(new Dimension(1440,900));
		
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver","D:\\VELOCITY LEC\\FireFox\\geckodriver.exe");
		    driver = new FirefoxDriver();
			 
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static String screenShot(String testCaseName,WebDriver driver) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileHandler.copy(source, target);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public Loginpage launchApplication() throws IOException
	{
		 driver =  launchBrowser();
		 log = new Loginpage(driver);
		 log.goTo();
		 return log;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() 
	{
	driver.close();	
	}
	
	
}
