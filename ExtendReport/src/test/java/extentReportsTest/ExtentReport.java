package extentReportsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReport {
	
	ExtentReports extent;
	
	
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter	reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
	    extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Shubham Dumbhare");
	}
	
	
	
	
	
	@Test
	public void initialDemo()
	{
	ExtentTest test = extent.createTest("Initial Demo");
	System.setProperty("webdriver.chrome.driver","D:\\VELOCITY LEC\\selinium\\Chrome\\Chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	System.out.println(driver.getTitle());
	driver.close();
	test.fail("Result do not match");
	extent.flush();
	}

}
