package testngcore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basics.DataproviderClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample 

{
	
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();

	@BeforeMethod

	public void lauchFormSubmit() {
		WebDriverManager.chromedriver().setup(); // to set the property via dependency
		driver = new ChromeDriver();
		//driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyCheckbox()
	{
		WebElement cb1=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		cb1.click();
		WebElement cb1text=driver.findElement(By.xpath("//label[contains(text(),'Click ')]"));
		String Expectedcb1text="Click on this check box";
		softassert.assertFalse(cb1.isSelected(),"Checkbox is selected by default , Failed ");
		softassert.assertEquals(cb1text.getText(), Expectedcb1text,"Checkbox texts is not matching");
		softassert.assertAll();
	}
	
	@Test(dataProvider = "Meesho Products",dataProviderClass = DataproviderClass.class)
	public void verifyProductSearch(String product)
	{
		System.out.println(product);
		driver.get("https://www.meesho.com/");
		WebElement searchbox=driver.findElement(By.xpath("//input[@type='text']"));
		searchbox.sendKeys(product +Keys.ENTER);
		
	}
	
	@Test(dataProvider = "Facebook Credentials",dataProviderClass = DataproviderClass.class)
	
	public void verifyFB(String username, String pwd, String name)
	{
		WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='pass']"));
		email.sendKeys(username);
		password.sendKeys(pwd);
		System.out.println("Name of user is "+name);
		
	}

	
	@AfterMethod

	public void closeBrowser() 
	{
		driver.quit();
	}


}
