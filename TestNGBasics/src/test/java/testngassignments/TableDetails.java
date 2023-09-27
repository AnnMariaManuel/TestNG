package testngassignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableDetails {
	
WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://selenium.obsqurazone.com/table-filter.php");
	}
	
	//TestCase1: Enter name "Brenden Wagner" in search field. Then verify whether All details of "Brenden Wagner" arrived
	
	@Test
	public void searchResult()
	{
		
		List<String>expectedList=new ArrayList<String>();
		expectedList.add("Brenden Wagner");
		expectedList.add("Software Engineer");
		expectedList.add("San Francisco");
		expectedList.add("27");
		expectedList.add("2011/06/07");
		expectedList.add("$206,850");
		System.out.println(expectedList);
		
		WebElement search=driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("Brenden Wagner");
		
		List<WebElement>searchResult=driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td"));
		List<String>actualList=new ArrayList<String>();
		for(WebElement item:searchResult)
		{
			actualList.add(item.getText());
		}
		/*for(int i=0;i<actualList.size();i++)
		{
			Assert.assertEquals(actualList.get(i), expectedList.get(i));
		}*/
		Assert.assertTrue(actualList.equals(expectedList),"Details displayed is wrong");
	}
	
	//TestCase 2: Enter name "Brenden Wagner" in search field. arrived Then verify message "Showing 1 to 1 of 1 entries (filtered from 57 total entries)"
	
	@Test
	public void verifyFiltermsg()
	{
		WebElement search=driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("Brenden Wagner");
		
		WebElement filtermsg=driver.findElement(By.xpath("//div[@id='example_info']"));
		String expectedfiltermsg="Showing 1 to 1 of 1 entries (filtered from 57 total entries)";
		
		Assert.assertEquals(filtermsg.getText(), expectedfiltermsg,"Filter result message is not the expected one !! ");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
