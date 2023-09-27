package testngassignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertErrormsg 


{
	
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
	
	@Test
	
	public void verifyErrorMsg()
	{
		WebElement submit_btn=driver.findElement(By.xpath("//button[@type='submit']"));
		submit_btn.click();
		ArrayList<String>Errormsg_actual=new ArrayList<String>();
		
		ArrayList<String>Errormsg_expected=new ArrayList<String>();
		Errormsg_expected.add("Please enter First name.");
		Errormsg_expected.add("Please enter Last name.");
		Errormsg_expected.add("Please choose a username.");
		Errormsg_expected.add("Please provide a valid city.");
		Errormsg_expected.add("Please provide a valid state.");
		Errormsg_expected.add("Please provide a valid zip.");
		Errormsg_expected.add("You must agree before submitting.");
		
		
		List<WebElement>Errormsg=driver.findElements(By.xpath("//div[@class='invalid-feedback']"));
		for(WebElement item:Errormsg)
		{
			Errormsg_actual.add(item.getText());
		}
		
		
		for (int i=0;i<Errormsg_expected.size();i++)
		{
			softassert.assertEquals(Errormsg_actual.get(i), Errormsg_expected.get(i),"Error messages not matching , Case is  Failed ");
		}
		
		
		softassert.assertAll();
		
	}
	
	
	@AfterMethod
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
