/*package Signup;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTask {
	 

		WebDriver driver = new ChromeDriver();

		String TheURL = "https://automationteststore.com/";
		String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
		Random rand = new Random();

		String TheUserName;
		String ThePassword = "Test@1234";

		@BeforeTest
		public void MySetup() {

			driver.get(TheURL);
			driver.manage().window().maximize();
		}
			
		@Test(priority = 4, enabled = true, invocationCount = 10)
	    public void AddtoCart() throws InterruptedException {
			driver.navigate().to(TheURL);
			
			Thread.sleep(1000);
			
			List<WebElement> theListOfIteams = driver.findElements(By.className("prdocutname"));
			
			
			
			// int TotalNumberOfIteams = theListOfIteams.size();
			
			int RandomIteamIndex = rand.nextInt(4);
			theListOfIteams.get(RandomIteamIndex).click();
			
			Thread.sleep(1000);
						
			if(driver.getPageSource().contains("Out of Stock")) {
				driver.navigate().back();
				System.out.println("Sorry the iteam out of stock");
				
			}else  {
				int RandomQuantityNumber = rand.nextInt(1,11);
				Integer QuantityNumber = RandomQuantityNumber ;
				
				WebElement Quantityfield = driver.findElement(By.id("product_quantity"));
				Quantityfield.sendKeys(String.valueOf(QuantityNumber));
				
				
				WebElement ProductPrice = driver.findElement(By.xpath("//div[@class='productfilneprice']"));
				WebElement TotalPrice = driver.findElement(By.xpath("//span[@class='total-price']"));
				
				
		/*	if (driver.getPageSource().contains(TotalPrice)) {
					
				WebElement 	AddToCartButton = driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']"));
					AddToCartButton.click();
					
					
				}else
					System.out.println("Subtotal is wrong!");
			}
			
			
		
		
		}
}*/
