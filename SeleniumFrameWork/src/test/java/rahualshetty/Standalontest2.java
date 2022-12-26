package rahualshetty;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commomCode.BaseCode;
import io.github.bonigarcia.wdm.WebDriverManager;

import pom.Cartpage;
import pom.Checkoutpage;
import pom.Confirmationpage;
import pom.Homepage;
import pom.Loginpage;
import pom.Orderpage;

public class Standalontest2 extends BaseCode{
//	public String text = "ZARA COAT 3";
	
		@Test(dataProvider = "getData")
		public void letsShopApp(HashMap<String,String> input) throws InterruptedException, IOException
		{
		
		log.userEmailAndPass(input.get("email"),input.get("pass"));
		Homepage homepage = log.logInButtonField();
		List<WebElement> products = homepage.getProductList();
		Cartpage cart =homepage.addProductToCart(input.get("productName"));
		homepage.clickOnCart();
		boolean any = cart.getProductName(input.get("productName"));
		Assert.assertTrue(any);
		Checkoutpage check = cart.buyNowButton();
		check.selectCountry("india");
		Confirmationpage confirmpage = check.sumitButton();
		String msg = confirmpage.getConfirmation();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    	}
		
		
		@Test(dependsOnMethods = {"letsShopApp"},dataProvider="getData")
		public void orderIteamValidate(HashMap<String,String> input)
		{
			log.userEmailAndPass(input.get("email"),input.get("pass"));
			Homepage homepage = log.logInButtonField();
			Orderpage orders = homepage.goToOrderPage();
			Assert.assertTrue(orders.verifyOrderIteamDisplay(input.get("productName")));
		}
		
		
		@DataProvider
		public Object[][] getData()
		{
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("email","sd8625060600@gmail.com");
			map.put("pass","S8625060600s");
			map.put("productName","ZARA COAT 3");
			return new Object[] [] {{map}};
		}
		
		
		
		
		
		
		
}
