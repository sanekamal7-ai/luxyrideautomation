package testCases;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.CorporateAccountRegistrationPage;
import pageObjects.LuxyHomePage;

public class TC_CorporateAccountRegistrationTest extends BaseClass
{
	
	@Test
	public void Verify_CorporateAccountRegistration() throws InterruptedException 
	{
		//logger.info("***** starting CorporateAccountRegistrationTest *****");
		try
		{
		LuxyHomePage lhp=new LuxyHomePage(driver);
		
		lhp.closepopup();
		lhp.clickcorporateprogram();
		//logger.info("clicked on corporatelink");
		
		lhp.clickregistercorporate();
		//logger.info("clicked on registercorporatelink");
		
		lhp.acceptCookies(driver);
		
		
		CorporateAccountRegistrationPage carp=new CorporateAccountRegistrationPage(driver);
		//logger.info("providing customer details");
		carp.setCompanyName(randomeString());
		carp.setBusinessAddress("LGA");
		carp.setFirstName("kamalauto");
		carp.setLastName("dev");
		carp.setEmail(randomeString()+"@yopmail.com");
		carp.setMobileNumber("208555"+randomeNumber());
		carp.chkPrivacyPolicy();
		carp.clickcreate();
		}
		catch(Exception e)
		{
			//logger.error("test failed");
			//logger.debug("debug logs");
		}
	
		//logger.info("***** finished CorporateAccountRegistrationTest *****");
	}
	
}


