package Signup;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();

	String TheURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();

	@BeforeTest
	public void MySetup() {

		driver.get(TheURL);
		driver.manage().window().maximize();
	}

	@Test
	public void Signup() throws InterruptedException {

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
		String Password = "Test@1234";

		// Actions
		FirstNameInput.sendKeys(randomFirstName);
		LastNameInput.sendKeys(randomLastName);
		EmailInput.sendKeys(Email);
		TelephoneInput.sendKeys(Telephone);
		FaxInput.sendKeys(Fax);
		CompanyInput.sendKeys(Company);
		Address1Input.sendKeys(Address1);
		Address2Input.sendKeys(Address2);
		CityInput.sendKeys(City);


		int numberOfCountryOperations = CountrySelect.findElements(By.tagName("option")).size();
		
		Select MySelectForTheCountry = new Select(CountrySelect);
		int randomCountryIndex = rand.nextInt(1, numberOfCountryOperations);
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
		LoginNameInput.sendKeys(randomFirstName + randomLastName + RandomNumberForTheEmail);
		PasswordInput.sendKeys(Password);
		PasswordConfirmInput.sendKeys(Password);
		AgreeBox.click();
		ContinueButtton.click();
	}

}