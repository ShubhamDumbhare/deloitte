package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commomCode.BaseCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.Cartpage;
import pom.Checkoutpage;
import pom.Confirmationpage;
import pom.Homepage;
import pom.Loginpage;

public class StepDefinitionImp extends BaseCode{
	
	public Loginpage log;
	public Homepage homepage;
	public Confirmationpage confirmpage;
	
	 @Given("I Landed on Ecommerce Page")
	 public void  I_Landed_on_Ecommerce_Page() throws IOException
	 {
		log = launchApplication();
	 }

	 @Given ("^Logged in with username (.+) and password (.+)$")
	 public void logged_in_username_password(String username,String password)
	 {
		 log.userEmailAndPass(username,password); 
	 }
	
	 @When ("^I add product (.+) to Cart$")
	 public void  I_add_product_to_Cart(String productName) throws InterruptedException
	 {
		 List<WebElement> products = homepage.getProductList();
		 Cartpage cart =homepage.addProductToCart(productName);
	 }
	 
	 
	 @And  ("^Checkout (.+) and submit the order$")
	 public void Checkout_and_submit_the_order(String productName) throws InterruptedException
	 {
		    Cartpage cart =homepage.addProductToCart(productName);
			homepage.clickOnCart();
			boolean any = cart.getProductName(productName);
			Assert.assertTrue(any);
			Checkoutpage check = cart.buyNowButton();
			check.selectCountry("india");
			confirmpage = check.sumitButton();
	 }
	 
	 
	 @Then ("^(.+) message is displayed on ConfirmationPage$")
	 public void message_is_displayed_on_ConfirmationPage(String ValidationMessage)
	 {
		 String msg = confirmpage.getConfirmation();
		 Assert.assertTrue(msg.equalsIgnoreCase(ValidationMessage)); 
	 }
	 
	 
	 
	 
	 
	 
	 
}
