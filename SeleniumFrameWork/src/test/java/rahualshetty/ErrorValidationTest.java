package rahualshetty;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import commomCode.BaseCode;
import commomCode.Retry;
import pom.Cartpage;
import pom.Checkoutpage;
import pom.Confirmationpage;
import pom.Homepage;
import pom.Loginpage;


public class ErrorValidationTest extends BaseCode{
		
		@Test(groups= {"ErrorHandling"}, retryAnalyzer = Retry.class)
		public void logInErrrorValidation() throws InterruptedException, IOException
		{
			String text = "ZARA COAT 3";
			log.userEmailAndPass("sd8625060600@gmail.com","S8625060600");
			log.logInButtonField();
			Assert.assertEquals("Incorrect email or password.", log.getErrorMassage());
		
    	}
		
		@Test
		public void productErrorValidation() throws InterruptedException, IOException
		{
		String text = "ZARA COAT 3";
		log.userEmailAndPass("sd8625060600@gmail.com","S8625060600s");
		Homepage homepage = log.logInButtonField();
		List<WebElement> products = homepage.getProductList();
		Cartpage cart =homepage.addProductToCart(text);
		homepage.clickOnCart();
		boolean any = cart.getProductName("ZARA COAT 33");
		Assert.assertFalse(any);
    	}
		
		
		
		
		
		
		
		
		
		
		
		
}
