package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Reusablemethod;

public class Loginpage extends Reusablemethod{
	
	WebDriver driver;
	
	@FindBy(id="userEmail")private WebElement email;
	@FindBy(id="userPassword")private WebElement password;
	@FindBy(id="login")private WebElement logInButton;
	@FindBy(css=".ng-trigger-flyInOut ")private WebElement errorMassage;

	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void userEmailAndPass(String Email , String Password)
	{
		email.sendKeys(Email);
		password.sendKeys(Password);
	}
	
	public Homepage logInButtonField()
	{
		logInButton.click();
		Homepage homepage = new Homepage(driver);
		return homepage;
	}
	
	public String getErrorMassage() 
	{
		explitWaitWebElement(errorMassage);
		return errorMassage.getText();
	}
	
	
	public void goTo() 
	{
	driver.get("https://rahulshettyacademy.com/client/");	
	}
}
