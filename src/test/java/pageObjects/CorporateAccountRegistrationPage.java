package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CorporateAccountRegistrationPage extends BasePage
{

	public CorporateAccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(id="companyName")
	WebElement txtcompanyname;
	
	@FindBy(xpath="//input[@placeholder='Enter Business Address']")
	WebElement txtbusinessaddress;
	
	@FindBy(id="firstName")
	WebElement txtfirstname;
	
	@FindBy(id="lastName")
	WebElement txtlastname;
	
	@FindBy(id="email")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement mobilenumber;
	
	@FindBy(xpath="//label[@for='isPartner']")
	WebElement radiobtn;
	
	@FindBy(xpath="//button[@value='Create']")
	WebElement createbtn;
	
	public void setCompanyName(String cname)
	{
		txtcompanyname.sendKeys(cname);
	}
	
	public void setBusinessAddress(String businessaddress) throws InterruptedException
	{
		txtbusinessaddress.sendKeys(businessaddress);
		driver.findElement(By.xpath("//li[normalize-space()='LaGuardia Airport (LGA), Queens, NY 11371, USA']")).click();
		Thread.sleep(2000);
	}
	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void setMobileNumber(String mnumber)
	{
		mobilenumber.sendKeys(mnumber);
	}
	
	public void chkPrivacyPolicy()
	{
		radiobtn.click();
	}
	
	public void clickcreate()
	{
		createbtn.click();
	}
    
	
	
}
