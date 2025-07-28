package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends BasePage
{

	public loginpage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(id="email")
	WebElement txtemailaddress;
	
	@FindBy(id="password")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[@value='Login and Continue']")
	WebElement loginbtn;
	
	public void setemail(String email) 
	{
		txtemailaddress.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
	    txtpassword.sendKeys(pwd);
	}
	
	public void loginbtn() throws InterruptedException
	{
		Thread.sleep(3000);
		loginbtn.click();
		Thread.sleep(2000);
	}
	

}
