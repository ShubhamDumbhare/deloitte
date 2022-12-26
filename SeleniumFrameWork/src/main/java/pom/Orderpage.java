package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Reusablemethod;

public class Orderpage extends Reusablemethod {
	
	WebDriver driver;
	

	@FindBy(xpath="//tbody/tr/td[2]") private List<WebElement> ordersName;
	
	public Orderpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	public Boolean verifyOrderIteamDisplay(String text)
	{
		
	    Boolean match = ordersName.stream().anyMatch(product->product.getText().equalsIgnoreCase(text));
	    return match;
	  
	}
	
	
	
	
	
	
}
