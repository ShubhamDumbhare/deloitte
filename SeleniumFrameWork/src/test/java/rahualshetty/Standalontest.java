package rahualshetty;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalontest {
	public static void main(String[] args) {
		
		String text = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("sd8625060600@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("S8625060600s");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> x = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement ele = x.stream().filter(product->
		product.findElement(By.cssSelector(".mb-3 b")).getText().equals(text)).findFirst().orElse(null);
		
		ele.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("(//button[@class=\"btn btn-custom\"])[3]")).click();
		
		List<WebElement> data = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean any = data.stream().anyMatch(datas->datas.getText().equalsIgnoreCase(text));
		Assert.assertTrue(any);
		
		driver.findElement(By.cssSelector("div.cartSection.removeWrap button")).click();
		driver.findElement(By.cssSelector(".form-group input.txt.text-validated")).sendKeys("india");
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		WebElement w = driver.findElement(By.cssSelector(".ta-item:nth-Child(3)"));
		w.click();
		
		
		
		
		
	}
}
 