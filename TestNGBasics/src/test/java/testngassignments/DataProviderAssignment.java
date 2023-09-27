package testngassignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basics.DataproviderClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderAssignment {
	
	
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	
	
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
	}

	
	@Test(dataProvider = "Form details", dataProviderClass = DataproviderClass.class)
	public void formSubmit(String fname, String lname, String uname, String city_name, String state_name,String pin)
	{
		
		WebElement firstName=driver.findElement(By.id("validationCustom01"));
		WebElement lastName=driver.findElement(By.id("validationCustom02"));
		WebElement userName=driver.findElement(By.id("validationCustomUsername"));
		WebElement city=driver.findElement(By.id("validationCustom03"));
		WebElement state=driver.findElement(By.id("validationCustom04"));
		WebElement pincode=driver.findElement(By.id("validationCustom05"));
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		userName.sendKeys(uname);
		city.sendKeys(city_name);
		state.sendKeys(state_name);
		pincode.sendKeys(pin);
		
		WebElement cb=driver.findElement(By.xpath("//input[@type='checkbox']"));
		cb.click();
		
		WebElement submitbtn=driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		
		String expectedvalidatiomsg="Looks good!";
		
		List<WebElement>validmsg=driver.findElements(By.xpath("//div[@class='valid-feedback']"));
		for(WebElement item :validmsg)
		{
			softassert.assertEquals(item.getText(), expectedvalidatiomsg,"Validation Success Text not matching: Fail ");
		}
		
		WebElement succesmsg=driver.findElement(By.xpath("//div[@id='message-one']"));
		String expectedsuccesmsg="Form has been submitted successfully!";
		softassert.assertEquals(succesmsg.getText(), expectedsuccesmsg,"Final message is not matching - fail");
		
		softassert.assertAll();
	
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
