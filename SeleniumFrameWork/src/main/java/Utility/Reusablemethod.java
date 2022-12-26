package Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.Cartpage;
import pom.Orderpage;



public class Reusablemethod {
	
	public WebDriver driver;
	
	@FindBy(xpath = "(//button[@class=\"btn btn-custom\"])[3]") private WebElement CartButton;
	@FindBy(css="button[routerlink=\"/dashboard/myorders\"]") private WebElement ordersTab;
	
	
	public Reusablemethod(WebDriver driver) {
		this.driver = driver;
	}

	public void explitWait(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void explitWaitWebElement(WebElement findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitToDisappear(WebElement we) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(we));
	}
	
	
	
	
	public void clickOnCart()
	{
		CartButton.click();
	}
	
	public Orderpage goToOrderPage()
	{
		ordersTab.click();
		Orderpage order = new Orderpage(driver);
		return order;
	}
	
	
	
	public void javaScriptExecutor()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
	}
	
}
