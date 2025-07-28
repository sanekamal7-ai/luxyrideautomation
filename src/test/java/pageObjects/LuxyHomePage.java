package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LuxyHomePage extends BasePage
{

	public LuxyHomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//button[@aria-label='Close dialog']")
	WebElement closepopup;
	
	@FindBy(xpath="//button[@value='Accept Cookies']")
	WebElement cookieBtn;
	
	@FindBy(xpath="//div[@class='flex justify-center items-center gap-x-1']//a[normalize-space()='Corporate Program']")
	WebElement lnkcorporateprogram;
	
	@FindBy(xpath="//a[@aria-label='Link for Try LUXY for Corporate Travel']")
	WebElement lnkregistercorporate;
	
	@FindBy(xpath="//div[@class='flex justify-center items-center gap-x-1']//a[normalize-space()='sign in']")
	WebElement customersignin;
	
	@FindBy(linkText="Customer Login")
	WebElement customerlogin;
	JavascriptExecutor js;
	
	
	
	
	public void closepopup() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
		Thread.sleep(1000);
	}
	
	public void clickcorporateprogram()
	{
		lnkcorporateprogram.click();
	}
	
	public void acceptCookies(WebDriver driver) 
	{
	    try 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Accept Cookies']")));
	        cookieBtn.click();
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Cookie button not found or already accepted. Continuing without clicking.");
	    }
	}
	
	public void clickregistercorporate()
	{
		JavascriptExecutor js1=(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy (0,300)","");
	    System.out.println(js1.executeScript("return window.pageYOffset;"));
		lnkregistercorporate.click();
	}
	
	public void customersignin() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath("//div[@class='flex justify-center items-center gap-x-1']//a[normalize-space()='sign in']"));
		 Actions action=new Actions(driver);
		 action.moveToElement(ele).perform();
		 driver.findElement(By.linkText("Customer Login")).click();
		 Thread.sleep(3000);
	}
	
	public void profile() throws InterruptedException
	{
		WebElement ele1=driver.findElement(By.xpath("//div[@class='flex justify-center items-center gap-x-1']//a[normalize-space()='Welcome kks']"));
		 Actions action1=new Actions(driver);
		 action1.moveToElement(ele1).perform();
		 driver.findElement(By.linkText("Profile")).click();
		 Thread.sleep(3000);
		 System.out.println("loggedin successfully");
		 driver.findElement(By.xpath("//img[@class='w-24 sm:w-16']")).click();
	}
	
}

