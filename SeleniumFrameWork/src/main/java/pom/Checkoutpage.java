package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Reusablemethod;

public class Checkoutpage extends Reusablemethod{
	
	WebDriver driver;
	
	@FindBy(css=".form-group input.txt.text-validated")private WebElement country;
	@FindBy(css=".ta-item:nth-Child(3)")private WebElement countryList;
	@FindBy(css=".action__submit")private WebElement placeorder;
	
	By placeOrder =  By.xpath("//div[@class=\"actions\"]//a");
	
	By countryWait = By.cssSelector(".ta-item");
	
	
public Checkoutpage(WebDriver driver)
{
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

public void selectCountry(String Country) throws InterruptedException
{
	country.sendKeys(Country);
	explitWait(countryWait);
	countryList.click();

	
}

public Confirmationpage sumitButton() throws InterruptedException
{
    
    javaScriptExecutor();
    Thread.sleep(1000);
	placeorder.click();
	Confirmationpage confirm  = new Confirmationpage(driver);
	return confirm;
}

}
