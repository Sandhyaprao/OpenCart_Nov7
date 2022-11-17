package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	@Test
	public void test_account_Registration()
	{
		logger.info("*****Starting the TC001_AccountRegistrationTest********** ");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		// logger.debug("Clicking on my account");
		
		logger.info("***Clicking on My Account***");
		hp.clickRegister(); 
		logger.info("***Clicking on Register***");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("***Providing customer data***");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphanumaric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivaccyPolicy();
		logger.info("***Clicking on Continue***");
		regpage.clickContinue();
	String confmsg=	regpage.getConfirmationMsg();
	
	logger.info("****Validating Expected Message***");
			
	//Assert.assertEquals(confmsg,"Your Account Has Been Created!"));
	Assert.assertEquals(confmsg,"Your Account Has Been Created!","Not getting expected Message");
		}
		
		catch (Exception e)
		{
			Assert.fail();
			
		}
		logger.info("*****completed the TC001_AccountRegistrationTest********** ");
	}
	
}
