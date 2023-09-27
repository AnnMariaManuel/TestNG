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

public class SimpleFormFill {
	
WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	}
	
	//verify Text of button "Show Message
	
	@Test(priority = 1)
	public void showMsg()
	{
		
		WebElement showmsgbox=driver.findElement(By.xpath("//button[@id='button-one']"));
		String actualmsg="Show Mesage";
		Assert.assertEquals(actualmsg, showmsgbox.getText(),"show message button text is not matching");
		System.out.println("Print stmnt after Assert");
	}
	
	//TestCase2: same url, enter a message in input field then click on show message button , then verify result message
	@Test(priority = 2)
	public void entermsg()
	{
		WebElement msgbox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		String msg="Ann";
		msgbox.sendKeys(msg);
		
		WebElement showmsgbox=driver.findElement(By.xpath("//button[@id='button-one']"));
		showmsgbox.click();
		WebElement msgdisply=driver.findElement(By.xpath("//div[@id='message-one']"));
		String actualmsg=msgdisply.getText();
		//System.out.println(actualmsg);
		//String s3=actualmsg.substring(15); we can check if msg.equals(s3) as well for this case 
		//System.out.println(s3);
		Assert.assertTrue(actualmsg.contains(msg),"Your Message displayed is wrong ");
		
		
		
	}
	//TestCase3: go to url= https://selenium.obsqurazone.com/check-box-demo.php click on any one checkbox , 
	//then verify whther it is Selected or not
	
	@Test(priority = 3)
	public void checkBox()
	{
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement cb1=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		cb1.click();
		
		Assert.assertTrue(cb1.isSelected(),"Checkbox is not selected ");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	

}
