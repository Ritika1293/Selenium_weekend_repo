package Ritika;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

public class Ritika_01 {
	
	@Listeners(ListenerUtility.class)
	public class TC_HMS_001_TEST extends BaseClass
	{
		@Test
		public void clickOnBooks()
		{
			ExtentTest test= eReport.createTest("clickOnBooks");
			HomePage home= new HomePage(driver);
			home.getBookLink().click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.");
			test.log(Status.PASS, "Git Hub testing");
			test.log(Status.PASS, "Git Hub testing");
		}

	}


}
