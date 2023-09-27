package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTestCase

{
	WebDriver driver;

	@BeforeMethod

	public void lauchMeesho() {
		WebDriverManager.chromedriver().setup(); // to set the property via dependency
		driver = new ChromeDriver();
		// WebDriverManager.edgedriver().setup();
		// WebDriver driver=new EdgeDriver();
		driver.get("https://www.meesho.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void verifyTitle()

	{
		String Actual_Title = driver.getTitle();
		System.out.println("The Actual title of the page is :" + Actual_Title);

		String Expected_Title = "Title is Ann";
		Assert.assertEquals(Actual_Title, Expected_Title,"This test case is a Fail"); // to compare the results

	}

	@Test
	public void verifyUrl() {

		String Actual_URL = driver.getCurrentUrl();
		String Expected_URL = "https://www.meesho.com/";
		Assert.assertEquals(Actual_URL, Expected_URL,"This is a Fail ");
	}

	@Test
	public void verifyCartOption() {
		WebElement cart_icon = driver.findElement(By.xpath("//span[text()='Cart']"));
		boolean status = cart_icon.isDisplayed();
		// Assert.assertEquals(status, true);
		Assert.assertTrue(status); // check if status is true
	}

}
