package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utility.Reusablemethod;

public class Homepage extends Reusablemethod {
	
	WebDriver driver;
	
	@FindBy(css=".mb-3")private List<WebElement> products;
	@FindBy(css=".ng-animating")private WebElement spinner;
	
	public Homepage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	By product = By.cssSelector(".mb-3");
	By addCart = By.cssSelector(".card-body button:last-of-type");
			
	public List<WebElement> getProductList()
	{
		explitWait(product);
		return products;
	}
	
	public WebElement getProductByName(String text)
	{
		WebElement ele = products.stream().filter(product->
		product.findElement(By.cssSelector(".mb-3 b")).getText().equals(text)).findFirst().orElse(null);
		return ele;
	}
	
	
	public Cartpage addProductToCart(String text) throws InterruptedException
	{
		WebElement ele = getProductByName(text);
		ele.findElement(addCart).click();
		explitWait(By.cssSelector("#toast-container"));
		waitToDisappear(spinner);
		Cartpage cart = new Cartpage(driver);
		return cart;
	}
	
	
	
	
	
	
	
	
}
