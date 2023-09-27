package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample 

{
	
	WebDriver driver;
	@BeforeMethod
	public void setBrowser()
	{
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("https://www.geico.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void zipEnter()
	{
		WebElement zip_code=driver.findElement(By.xpath("//input[@id='ssp-service-zip']"));
		   zip_code.sendKeys("123456");
		   WebElement Go_btn=driver.findElement(By.xpath("//input[@type='submit' and @value='Go']"));
		   Go_btn.click();
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		   WebElement text=driver.findElement(By.xpath("//p[contains(text(),'Thanks! Select')]"));
		   System.out.println("action done ");
		   System.out.println(text.getText());
		   
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	}
		
	}


