package testngcore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormValidationTestcases

{

	WebDriver driver;

	@BeforeMethod

	public void lauchFormSubmit() {
		WebDriverManager.chromedriver().setup(); // to set the property via dependency
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 2,dependsOnMethods = "verifyLogo")

	public void VerifySubmitbtnText() {
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		String Actual_Text = submitbtn.getText();
		String Expected_Text = "Submit form";
		Assert.assertEquals(Actual_Text, Expected_Text, "Button text is not matching ");
	}

	@Test(priority = 2,enabled = false)
	
	public void VerifyTCtext()
	{
		WebElement T_C=driver.findElement(By.xpath("//label[@for='invalidCheck']"));
		String Actual_Text=T_C.getText();
		String Expected_Text="Agreee To T & C ";
		Assert.assertEquals(Actual_Text, Expected_Text,"T & C text is not matching ; Case Failed");
	}

	@Test(priority = 1)

	public void verifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//a[@href='index.php']/img"));
		//Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed ");
		Assert.assertFalse(logo.isDisplayed(), "Logo is not displayed ");
	}
	
	

	@AfterMethod

	public void closeBrowser() {
		driver.quit();
	}

}
