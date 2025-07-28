package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.LuxyHomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginpage;

public class Tc002_LoginTest extends BaseClass
{
@Test
public void verify_login()
  {
	try
	{
	
	LuxyHomePage lhp=new LuxyHomePage(driver);
	lhp.closepopup();
	lhp.acceptCookies(driver);
	lhp.customersignin();
	
	loginpage lp=new loginpage(driver);
	lp.setemail(p.getProperty("email"));
	System.out.println("Logging in with: " + p.getProperty("email"));
	lp.setpassword(p.getProperty("pwd"));
	lp.loginbtn();
	lhp.profile();
	System.out.println("verified profile successfully");
	
	}
	catch(Exception e)
	{
		System.out.println("not logged in");
	}
  }
}
