package computers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_HMS_010_TEST extends BaseClass
{
	@Test
	public void clickOnComputers()
	{
		ExtentTest test = eReport.createTest("clickOnComputers");
		test.log(Status.INFO, "test execution starts");
		HomePage home= new HomePage(driver);
		home.getComputerLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		test.log(Status.PASS, "COMPUTERS PAGE IS DISPLAYED");
	}

}
