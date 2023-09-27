package basics;

import org.testng.annotations.DataProvider;

public class DataproviderClass 
{

	@DataProvider (name="Meesho Products")
	
	public Object[][] dataProviderMeesho()
	{
		return new Object[][] {{"iPhone"},{"Shoe"},{"Watch"}};
	}
	@DataProvider (name="Facebook Credentials")
	
	public Object[][] dataProviderFacebook()
	{
		return new Object[][] {{"anntony@gmail.com","abc1234","Anntony"},{"annmariakunnamkott@gmail.com","jhrtg45","Ann Manuel"},{"tonymj@yahoo.com","ghjn456","Tony Joseph"}};
	}
	
	@DataProvider(name="Form details")
	public Object[][] dataProviderUserform()
	{
			return new Object[][]{{"Ann","Manuel","Anne","Kottayam","kerala","685669"},{"Emma","Tony","Emmuz","pala","Kerala","685608"}};
	}
	
}

