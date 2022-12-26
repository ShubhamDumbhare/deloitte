package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Reusablemethod;

public class Confirmationpage extends Reusablemethod{
	
	WebDriver driver;
	
  @FindBy(css=".hero-primary") private WebElement confirmMsg;
  
  By confirmMSG = By.cssSelector(".hero-primary");
	
	public Confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	
	public String getConfirmation()
	{
		explitWait(confirmMSG);
		return confirmMsg.getText();
	}
}
