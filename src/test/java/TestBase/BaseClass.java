package TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;
	//public Logger logger;
	public Properties p;
	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Throwable
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		//logger=LogManager.getLogger(this.getClass());
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			    if (br.equalsIgnoreCase("chrome")) 
			    {
			        ChromeOptions options = new ChromeOptions();
			        // You can still set platformName if needed:
			        options.setPlatformName(os.equalsIgnoreCase("mac") ? "MAC" : "WINDOWS");
			        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

			    } 
			    else if (br.equalsIgnoreCase("edge")) 
			    {
			        EdgeOptions options = new EdgeOptions();
			        options.setPlatformName(os.equalsIgnoreCase("mac") ? "MAC" : "WINDOWS");
			        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

			    } 
			    else 
			    {
			        System.out.println("No matching browser for remote");
			        return;
			    }
		}

	
		
		//driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		
    
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name"); return;
			}
		}
	
		
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://devnew.luxyride.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	public String randomeString()
	{
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(4);
		return generatednumber;
	}

}
