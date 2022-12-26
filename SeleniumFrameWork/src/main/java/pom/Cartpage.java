package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Reusablemethod;

public class Cartpage extends Reusablemethod{
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")private List<WebElement> iteamName;
	@FindBy(css="div.cartSection.removeWrap button")private WebElement buyNow;
	
	public Cartpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean getProductName(String text) 
	{
		
		boolean any =iteamName.stream().anyMatch(datas->datas.getText().equalsIgnoreCase(text));
		return any;
	}
	
	public Checkoutpage buyNowButton()
	{
		buyNow.click();
		Checkoutpage checkout = new Checkoutpage(driver);
		return checkout;
	}

	
	
	

	
	
	
	
}
