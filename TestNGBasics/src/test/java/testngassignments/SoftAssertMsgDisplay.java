package testngassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertMsgDisplay {
	
	
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	
  @BeforeMethod
  public void launchBrowser()
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	  driver.manage().window().maximize();
  }

  
  @Test
  public void verifymsgandResult()
  {
	  WebElement shwmsg=driver.findElement(By.xpath("//button[@id='button-one']"));
	  String btntext_Expected="Show Message";
	  softassert.assertEquals(shwmsg.getText(), btntext_Expected,"Button texts are not matching");
	  
	  WebElement enter_msg=driver.findElement(By.xpath("//input[@id='single-input-field']"));
	  String msg="Hi I am Ema!";
	  enter_msg.sendKeys(msg);
	  
	  shwmsg.click();
	  
	  WebElement msgdisplay=driver.findElement(By.xpath("//div[@id='message-one']"));
	  String message_displayed=msgdisplay.getText();
	  String actualmsg_entered=message_displayed.substring(15);
	  
	  softassert.assertEquals(actualmsg_entered, msg,"The message dispalyed is not the one entered !!");
	  softassert.assertAll();
	  
	 
  }
  
  @AfterMethod
  public void closeBrowser()
  {
	  driver.quit();
  }
}
