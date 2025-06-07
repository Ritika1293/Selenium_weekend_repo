package genericutility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener
{
	@Override
	public void onTestStart(ITestResult result) {
		test = eReport.createTest("clickOnBooks");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.INFO, "TEST SCRIPT IS FAILED");
		TakesScreenshot ts= (TakesScreenshot) driver;
		String scteenshot= ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(scteenshot);			
		
		try {
			wu.getScreenshots(driver);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
