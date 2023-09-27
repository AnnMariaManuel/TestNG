package testngassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmployeeDetails 


{
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://selenium.obsqurazone.com/table-pagination.php");
	}

	
	//TestCase 1: Verify whether "Name" header is present in webtable
	@Test(priority = 1)
	public void verifyNameHeader()
	{
		WebElement nameHeader=driver.findElement(By.xpath("//table[@id='dtBasicExample']/thead/tr/th[1]"));
		boolean headerDisplay=nameHeader.isDisplayed();
		Assert.assertTrue(headerDisplay,"Name header  is not present in the page ");
		
	}
	
	//Testcase 2: Verify heading message "Table with Pagination Example" is present 
	
	@Test(priority = 2)
	public void verifyHeadingMsg()
	{
		WebElement headermsgitem=driver.findElement(By.xpath("//div[contains(text(),'Table')]"));
		
		//boolean headermsgitemdisplay=headermsgitem.isDisplayed();
		Assert.assertTrue(headermsgitem.isDisplayed(),"heading message \"Table with Pagination Example\" is not present");
		
	}
	
	//Testcase3: Verify "Cedric Kelly" office is "Edinburgh"
	@Test(priority = 3)
	public void verifyCedric()
	{
		WebElement  Cedric_Office=driver.findElement(By.xpath("//table[@id='dtBasicExample']/tbody/tr[4]/td[3]"));
		String expectedVal="Edinburgh";
		Assert.assertEquals(Cedric_Office.getText(), expectedVal,"\"Cedric Kelly\" office is not displayed as  \"Edinburgh\"");
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
