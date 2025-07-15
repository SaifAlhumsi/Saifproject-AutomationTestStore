package Signup;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();

	String TheURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();

	String TheUserName;
	String ThePassword = "Test@1234";
	String FirstName;

	@BeforeTest
	public void MySetup() {

		driver.get(TheURL);
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = true)
	public void Signup() throws InterruptedException {
		
		String ConfirmationMessage = "Your Account Has Been Created!";
		driver.navigate().to(SignupPage);

		// Elements
		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNameInput = driver.findElement(By.name("lastname"));
		WebElement EmailInput = driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
		WebElement TelephoneInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement FaxInput = driver.findElement(By.name("fax"));
		WebElement CompanyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement Address1Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
		WebElement Address2Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement AgreeBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButtton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		// or we can use
		// WebElement ContinueButtton =
		// driver.findElement(By.cssSelector("button[title='Continue']"));

		WebElement CountrySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateSelect = driver.findElement(By.id("AccountFrm_zone_id"));

		// data
		String[] FirstNames = { "ahmed", "omar", "ali", "saif", "khalid", "anas", "osama", "marwan" };
		int randomIndexForFirstName = rand.nextInt(FirstNames.length);
		String randomFirstName = FirstNames[randomIndexForFirstName];
		FirstName = randomFirstName;
		
		String[] LastNames = { "adel", "qusai", "fares", "hamed", "talal", "zeid", "qais" };
		int randomIndexForLastName = rand.nextInt(LastNames.length);
		String randomLastName = LastNames[randomIndexForLastName];

		int RandomNumberForTheEmail = rand.nextInt(7000);
		String Email = randomFirstName + randomLastName + RandomNumberForTheEmail + "@gmail.com";

		String Telephone = "9620985672343";
		String Fax = "9620985672343";
		String Company = "Amazon";
		String Address1 = "Amman Dahet Alrasheed";
		String Address2 = "Amman TlaaelAli";
		String City = "Amman";
		String PostalCode = "2342";

		// Actions

		TheUserName = randomFirstName + randomLastName + RandomNumberForTheEmail;
		FirstNameInput.sendKeys(randomFirstName);
		LastNameInput.sendKeys(randomLastName);
		EmailInput.sendKeys(Email);
		TelephoneInput.sendKeys(Telephone);
		FaxInput.sendKeys(Fax);
		CompanyInput.sendKeys(Company);
		Address1Input.sendKeys(Address1);
		Address2Input.sendKeys(Address2);
		CityInput.sendKeys(City);

		int TotalCountries = CountrySelect.findElements(By.tagName("option")).size();

		Select MySelectForTheCountry = new Select(CountrySelect);
		int randomCountryIndex = rand.nextInt(1, TotalCountries);
		MySelectForTheCountry.selectByIndex(randomCountryIndex);

		// or we can use selectByVisibleText to specify a specific Country
		// MySelectForTheCountry.selectByVisibleText("Jordan");

		Thread.sleep(1000);

		int numberOfStateOperations = StateSelect.findElements(By.tagName("option")).size();

		Select MySelectForTheState = new Select(StateSelect);
		int randomStateIndex = rand.nextInt(1, numberOfStateOperations);
		MySelectForTheState.selectByIndex(randomStateIndex);
		// or we can use selectByValue to specify a specific value
		// MySelectForTheState.selectByValue("1705");

		PostalCodeInput.sendKeys(PostalCode);
		LoginNameInput.sendKeys(TheUserName);
		PasswordInput.sendKeys(ThePassword);
		PasswordConfirmInput.sendKeys(ThePassword);
		AgreeBox.click();
		ContinueButtton.click();
		
		Thread.sleep(3000);

		boolean ActualResult = driver.getPageSource().contains(ConfirmationMessage);
		Assert.assertEquals(ActualResult, true, "this is to test that the account has been created");
	}

	@Test(priority = 2, enabled = true)
	public void Logout() throws InterruptedException {
		
		String ConfirmationMessage = "You have been logged off your account. It is now safe to leave the computer.";
		WebElement Logoutbutton = driver.findElement(By.linkText("Logoff"));
		Logoutbutton.click();

		Thread.sleep(1000);
		
		boolean ActualResult = driver.getPageSource().contains(ConfirmationMessage);
		Assert.assertEquals(ActualResult, true, "this is to test that the account has logged out");
		
		
		boolean ActualResult2 = driver.getCurrentUrl().equals("https://automationteststore.com/index.php?rt=account/logout");
		boolean ExpectedResult2 = true;
		Assert.assertEquals(ActualResult2, ExpectedResult2);


		WebElement Continuebutton = driver.findElement(By.linkText("Continue"));
		Continuebutton.click();

	}

	@Test(priority = 3, enabled = true)
	public void Login() throws InterruptedException {

		WebElement LoginandRegisterbutton = driver.findElement(By.partialLinkText("Login or register"));
		LoginandRegisterbutton.click();

		WebElement Loginname = driver.findElement(By.id("loginFrm_loginname"));
		WebElement Password = driver.findElement(By.id("loginFrm_password"));
		Loginname.sendKeys(TheUserName);
		Password.sendKeys(ThePassword);

		WebElement Loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		Loginbutton.click();
		
		Thread.sleep(1000);
		
		boolean ActauLResult = driver.findElement(By.id("customernav")).getText().contains(FirstName);
		Assert.assertEquals(ActauLResult, true);
		
		//optional
		
		String ActualResult2 = driver.findElement(By.id("customernav")).getText();
		String ExpectedResult2 = "Welcome back " + FirstName;
		Assert.assertEquals(ActualResult2, ExpectedResult2);
		
	}

	@Test(priority = 4, enabled = false, invocationCount = 15)
	public void AddtoCart() throws InterruptedException {
		driver.navigate().to(TheURL);

		Thread.sleep(1000);

		List<WebElement> theListOfIteams = driver.findElements(By.className("prdocutname"));

		int TotalNumberOfIteams = theListOfIteams.size();

		int RandomIteamIndex = rand.nextInt(TotalNumberOfIteams);
		theListOfIteams.get(RandomIteamIndex).click();

		Thread.sleep(1000);

		WebElement AddToCartButton = driver.findElement(By.className("productpagecart"));

		if (AddToCartButton.getText().equals("Out of Stock")) {
			driver.navigate().back();

			System.out.println("Sorry the iteam out of stock");

		} else {
			if (driver.getCurrentUrl().contains("product_id=116")) {
				driver.findElement(By.xpath("//input[@id='option344747']")).click();

			}
			AddToCartButton.click();
			Thread.sleep(1000);
			WebElement CheckOutButton = driver.findElement(By.linkText("Checkout"));
			CheckOutButton.click();
		}
	}

}
