package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(linkText="Welcome kks")
	WebElement userlogintitle;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return (userlogintitle.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

}
